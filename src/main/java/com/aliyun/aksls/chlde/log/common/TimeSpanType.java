package com.aliyun.aksls.chlde.log.common;

import java.lang.reflect.Type;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;

public enum TimeSpanType implements JSONSerializable {
    RELATIVE("Relative"),
    TRUNCATED("Truncated"),
    TODAY("Today"),
    CUSTOM("Custom");

    private final String value;

    TimeSpanType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static TimeSpanType fromString(String value) {
        for (TimeSpanType timeSpanType : TimeSpanType
            .values()) {
            if (timeSpanType.value.equals(value)) {
                return timeSpanType;
            }
        }
        throw new IllegalArgumentException("Invalid timespan type: " + value);
    }

    @Override
    public void write(JSONSerializer serializer, Object fieldName, Type fieldType, int features) {
        serializer.write(toString());
    }
}
