package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.Alert;
import com.aliyun.aksls.chlde.log.exception.LogException;
import com.aliyun.aksls.chlde.log.internal.ErrorCodes;
import net.sf.json.JSONObject;

public class GetAlertResponse extends Response {

    private static final long serialVersionUID = 889623903109968396L;

    private Alert alert;

    public GetAlertResponse(Map<String, String> headers) {
        super(headers);
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    public void deserialize(JSONObject value, String requestId) throws LogException {
        alert = new Alert();
        try {
            alert.deserialize(value);
        } catch (final Exception ex) {
            throw new LogException(ErrorCodes.BAD_RESPONSE, "Unable to deserialize JSON to model: " + ex.getMessage(), ex, requestId);
        }
    }
}
