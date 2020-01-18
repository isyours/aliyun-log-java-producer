package com.aliyun.aksls.chlde.log.response;

import java.io.Serializable;
import java.util.Map;

import com.aliyun.aksls.chlde.log.common.ETL;
import com.aliyun.aksls.chlde.log.internal.Unmarshaller;
import net.sf.json.JSONArray;

public class ListETLResponse extends ResponseList<ETL> implements Serializable {

    private static final long serialVersionUID = -6158296540776923094L;

    public ListETLResponse(Map<String, String> headers) {
        super(headers);
    }

    @Override
    public Unmarshaller<ETL> unmarshaller() {
        return new Unmarshaller<ETL>() {
            @Override
            public ETL unmarshal(JSONArray value, int index) {
                ETL etl = new ETL();
                etl.deserialize(value.getJSONObject(index));
                return etl;
            }
        };
    }
}
