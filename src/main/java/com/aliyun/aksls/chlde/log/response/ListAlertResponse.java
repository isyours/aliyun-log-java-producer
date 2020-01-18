package com.aliyun.aksls.chlde.log.response;

import java.io.Serializable;
import java.util.Map;

import com.aliyun.aksls.chlde.log.common.Alert;
import com.aliyun.aksls.chlde.log.internal.Unmarshaller;
import net.sf.json.JSONArray;

public class ListAlertResponse extends ResponseList<Alert> implements Serializable {
    
    private static final long serialVersionUID = 5068019621076631746L;

    public ListAlertResponse(Map<String, String> headers) {
        super(headers);
    }

    @Override
    public Unmarshaller<Alert> unmarshaller() {
        return new Unmarshaller<Alert>() {
            @Override
            public Alert unmarshal(JSONArray value, int index) {
                Alert alert = new Alert();
                alert.deserialize(value.getJSONObject(index));
                return alert;
            }
        };
    }
}
