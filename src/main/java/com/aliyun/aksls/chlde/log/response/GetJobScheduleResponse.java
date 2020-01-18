package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.JobSchedule;
import com.aliyun.aksls.chlde.log.exception.LogException;
import com.aliyun.aksls.chlde.log.internal.ErrorCodes;
import net.sf.json.JSONObject;

public class GetJobScheduleResponse extends Response {

    private static final long serialVersionUID = 4220425087831824694L;

    private JobSchedule jobSchedule;

    public GetJobScheduleResponse(Map<String, String> headers) {
        super(headers);
    }

    public JobSchedule getJobSchedule() {
        return jobSchedule;
    }

    public void deserialize(JSONObject value, String requestId) throws LogException {
        jobSchedule = new JobSchedule();
        try {
            jobSchedule.deserialize(value);
        } catch (final Exception ex) {
            throw new LogException(ErrorCodes.BAD_RESPONSE, "Unable to deserialize JSON to model: " + ex.getMessage(), ex, requestId);
        }
    }
}
