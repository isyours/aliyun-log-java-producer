package com.aliyun.aksls.chlde.log.common;

import java.lang.reflect.Type;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;

public enum JobType implements JSONSerializable {
    ALERT("Alert"),
    REPORT("Report"),
    ETL("ETL"),
    ;

    private final String value;

    JobType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static JobType fromString(String value) {
        for (JobType type : JobType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Illegal job type: " + value);
    }

    @Override
    public void write(JSONSerializer serializer, Object fieldName, Type fieldType, int features) {
        serializer.write(toString());
    }
}