package com.aliyun.aksls.chlde.log.internal;


import net.sf.json.JSONArray;

public interface Unmarshaller<T> {

    T unmarshal(JSONArray value, int index);
}