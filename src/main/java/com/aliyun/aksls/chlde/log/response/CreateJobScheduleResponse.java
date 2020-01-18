package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.exception.LogException;
import com.aliyun.aksls.chlde.log.internal.ErrorCodes;
import net.sf.json.JSONObject;

public class CreateJobScheduleResponse extends Response {

    private static final long serialVersionUID = -5621961744515959340L;

    private String id;

    public CreateJobScheduleResponse(Map<String, String> headers) {
        super(headers);
    }

    public String getId() {
        return id;
    }

    public void deserialize(JSONObject value, String requestId) throws LogException {
        try {
            id = value.getString("id");
        } catch (final Exception ex) {
            throw new LogException(ErrorCodes.BAD_RESPONSE, "Unable to deserialize response: " + ex.getMessage(), ex, requestId);
        }
    }
}
