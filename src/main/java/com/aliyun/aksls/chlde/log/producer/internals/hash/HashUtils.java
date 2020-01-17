package com.aliyun.aksls.chlde.log.producer.internals.hash;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkPositionIndexes;

/**
 * Created by haolong.chl@alibaba-inc.com on 2019/7/25.
 */
public class HashUtils {

    public static final HashUtils INSTENCE = new HashUtils();

    public HashCode hashString(CharSequence input, Charset charset) {
        return hashBytes(input.toString().getBytes(charset));
    }

    private HashCode hashBytes(byte[] input) {
        return hashBytes(input, 0, input.length);
    }

    private HashCode hashBytes(byte[] input, int off, int len) {
        checkPositionIndexes(off, off + len, input.length);
        return newHasher(len).putBytes(input, off, len).hash();
    }

    private Hasher newHasher(int expectedInputSize) {
        checkArgument(
            expectedInputSize >= 0, "expectedInputSize must be >= 0 but was %s", expectedInputSize);
        return newHasher();
    }

    private Hasher newHasher() {
        return newHasherInner(32);
    }

    private Hasher newHasherInner(int expectedInputSize) {
        Preconditions.checkArgument(expectedInputSize >= 0);
        return new BufferingHasher(expectedInputSize);
    }

    public HashCode hashBytesInnerImpl(byte[] input, int off, int len) {
        checkPositionIndexes(off, off + len, input.length);
        return HashCode.fromLong(FingerPrint.fingerprint(input, off, len));
    }

    private final class BufferingHasher implements Hasher {
        final ExposedByteArrayOutputStream stream;
        public BufferingHasher(int expectedInputSize) {
            this.stream = new ExposedByteArrayOutputStream(expectedInputSize);
        }

        @Override
        public Hasher putByte(byte b) {
            stream.write(b);
            return this;
        }

        @Override
        public Hasher putBytes(byte[] bytes) {
            stream.write(bytes);
            return this;
        }

        @Override
        public Hasher putBytes(byte[] bytes, int off, int len) {
            stream.write(bytes, off, len);
            return this;
        }

        @Override
        public Hasher putShort(short i) {
            return this;
        }

        @Override
        public Hasher putInt(int i) {
            return this;
        }

        @Override
        public Hasher putLong(long l) {
            return this;
        }

        @Override
        public Hasher putFloat(float v) {
            return this;
        }

        @Override
        public Hasher putDouble(double v) {
            return this;
        }

        @Override
        public Hasher putBoolean(boolean b) {
            return this;
        }

        @Override
        public Hasher putChar(char c) {
            return this;
        }

        @Override
        public Hasher putUnencodedChars(CharSequence charSequence) {
            return this;
        }

        @Override
        public Hasher putString(CharSequence charSequence, Charset charset) {
            return this;
        }

        @Override
        public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
            return this;
        }

        @Override
        public HashCode hash() {
            return hashBytesInnerImpl(stream.byteArray(), 0, stream.length());
        }
    }

    private static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        ExposedByteArrayOutputStream(int expectedInputSize) {
            super(expectedInputSize);
        }

        @Override
        public void write(byte[] inputBytes) {
            ByteBuffer input = ByteBuffer.wrap(inputBytes);
            int remaining = input.remaining();
            if (count + remaining > buf.length) {
                buf = Arrays.copyOf(buf, count + remaining);
            }
            input.get(buf, count, remaining);
            count += remaining;
        }

        byte[] byteArray() {
            return buf;
        }

        int length() {
            return count;
        }
    }
}
