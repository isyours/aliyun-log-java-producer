package com.aliyun.openservices.aliyun.log.producer.internals.hash;

import java.nio.ByteOrder;

import com.google.common.primitives.Longs;
import sun.misc.Unsafe;

/**
 * Created by haolong.chl@alibaba-inc.com on 2019/7/25.
 */
public class LittleEndianByteArray {
    private static final LittleEndianBytes byteArray;

    static int load32(byte[] source, int offset) {
        // TODO(user): Measure the benefit of delegating this to LittleEndianBytes also.
        return (source[offset] & 0xFF)
            | ((source[offset + 1] & 0xFF) << 8)
            | ((source[offset + 2] & 0xFF) << 16)
            | ((source[offset + 3] & 0xFF) << 24);
    }

    static long load64(byte[] input, int offset) {
        // We don't want this in production code as this is the most critical part of the loop.
        assert input.length >= offset + 8;
        // Delegates to the fast (unsafe) version or the fallback.
        return byteArray.getLongLittleEndian(input, offset);
    }

    private interface LittleEndianBytes {
        long getLongLittleEndian(byte[] array, int offset);

        void putLongLittleEndian(byte[] array, int offset, long value);
    }

    /**
     * The only reference to Unsafe is in this nested class. We set things up so that if
     * Unsafe.theUnsafe is inaccessible, the attempt to load the nested class fails, and the outer
     * class's static initializer can fall back on a non-Unsafe version.
     */
    private enum UnsafeByteArray implements LittleEndianBytes {
        // Do *not* change the order of these constants!
        UNSAFE_LITTLE_ENDIAN {
            @Override
            public long getLongLittleEndian(byte[] array, int offset) {
                return theUnsafe.getLong(array, (long) offset + BYTE_ARRAY_BASE_OFFSET);
            }

            @Override
            public void putLongLittleEndian(byte[] array, int offset, long value) {
                theUnsafe.putLong(array, (long) offset + BYTE_ARRAY_BASE_OFFSET, value);
            }
        },
        UNSAFE_BIG_ENDIAN {
            @Override
            public long getLongLittleEndian(byte[] array, int offset) {
                long bigEndian = theUnsafe.getLong(array, (long) offset + BYTE_ARRAY_BASE_OFFSET);
                // The hardware is big-endian, so we need to reverse the order of the bytes.
                return Long.reverseBytes(bigEndian);
            }

            @Override
            public void putLongLittleEndian(byte[] array, int offset, long value) {
                // Reverse the order of the bytes before storing, since we're on big-endian hardware.
                long littleEndianValue = Long.reverseBytes(value);
                theUnsafe.putLong(array, (long) offset + BYTE_ARRAY_BASE_OFFSET, littleEndianValue);
            }
        };

        // Provides load and store operations that use native instructions to get better performance.
        private static final Unsafe theUnsafe;

        // The offset to the first element in a byte array.
        private static final int BYTE_ARRAY_BASE_OFFSET;

        /**
         * Returns a sun.misc.Unsafe. Suitable for use in a 3rd party package. Replace with a simple
         * call to Unsafe.getUnsafe when integrating into a jdk.
         *
         * @return a sun.misc.Unsafe instance if successful
         */
        private static sun.misc.Unsafe getUnsafe() {
            try {
                return sun.misc.Unsafe.getUnsafe();
            } catch (SecurityException tryReflectionInstead) {
                // We'll try reflection instead.
            }
            try {
                return java.security.AccessController.doPrivileged(
                    new java.security.PrivilegedExceptionAction<sun.misc.Unsafe>() {
                        @Override
                        public sun.misc.Unsafe run() throws Exception {
                            Class<sun.misc.Unsafe> k = sun.misc.Unsafe.class;
                            for (java.lang.reflect.Field f : k.getDeclaredFields()) {
                                f.setAccessible(true);
                                Object x = f.get(null);
                                if (k.isInstance(x)) {
                                    return k.cast(x);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
            } catch (java.security.PrivilegedActionException e) {
                throw new RuntimeException("Could not initialize intrinsics", e.getCause());
            }
        }

        static {
            theUnsafe = getUnsafe();
            BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);

            // sanity check - this should never fail
            if (theUnsafe.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }
    }

    private enum JavaLittleEndianBytes implements LittleEndianBytes {
        INSTANCE {
            @Override
            public long getLongLittleEndian(byte[] source, int offset) {
                return Longs.fromBytes(
                    source[offset + 7],
                    source[offset + 6],
                    source[offset + 5],
                    source[offset + 4],
                    source[offset + 3],
                    source[offset + 2],
                    source[offset + 1],
                    source[offset]);
            }

            @Override
            public void putLongLittleEndian(byte[] sink, int offset, long value) {
                long mask = 0xFFL;
                for (int i = 0; i < 8; mask <<= 8, i++) {
                    sink[offset + i] = (byte) ((value & mask) >> (i * 8));
                }
            }
        };
    }

    static {
        LittleEndianBytes theGetter = JavaLittleEndianBytes.INSTANCE;
        try {
      /*
        UnsafeByteArray uses Unsafe.getLong() in an unsupported way, which is known to cause crashes
        on Android when running in 32-bit mode. For maximum safety, we shouldn't use
        Unsafe.getLong() at all, but the performance benefit on x86_64 is too great to ignore, so as
        a compromise, we enable the optimization only on platforms that we specifically know to
        work.

        In the future, the use of Unsafe.getLong() should be replaced by ByteBuffer.getLong(), which
        will have an efficient native implementation in JDK 9.

      */
            final String arch = System.getProperty("os.arch");
            if ("amd64".equals(arch)) {
                theGetter =
                    ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)
                        ? UnsafeByteArray.UNSAFE_LITTLE_ENDIAN
                        : UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable t) {
            // ensure we really catch *everything*
        }
        byteArray = theGetter;
    }
}
