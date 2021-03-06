package com.aliyun.aksls.chlde.log.common;

import java.lang.reflect.Type;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;

public enum NotificationType implements JSONSerializable {
    /**
     * Ding ding web hook.
     */
    DING_TALK("DingTalk"),
    /**
     * Send email.
     */
    EMAIL("Email"),
    /**
     * Send message to message center.
     */
    MESSAGE_CENTER("MessageCenter"),
    /**
     * Send SMS.
     */
    SMS("SMS"),
    /**
     * Send HTTP request to target uri.
     */
    WEBHOOK("Webhook"),
    /**
     * Send voice to phone number.
     */
    VOICE("Voice");

    private final String value;

    NotificationType(String value) {
        this.value = value;
    }

    public static NotificationType fromString(String value) {
        for (NotificationType type : NotificationType
            .values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown notification type: " + value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public void write(JSONSerializer serializer, Object fieldName, Type fieldType, int features) {
        serializer.write(toString());
    }
}
