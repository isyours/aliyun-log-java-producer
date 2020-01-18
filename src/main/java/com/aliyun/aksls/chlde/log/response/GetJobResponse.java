package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.Job;
import com.aliyun.aksls.chlde.log.exception.LogException;
import com.aliyun.aksls.chlde.log.internal.ErrorCodes;
import net.sf.json.JSONObject;

public class GetJobResponse extends Response {

    private static final long serialVersionUID = 6142695979281167810L;

    private Job job;

    public GetJobResponse(Map<String, String> headers) {
        super(headers);
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void deserialize(JSONObject value, String requestId) throws LogException {
        job = new Job();
        try {
            job.deserialize(value);
        } catch (final Exception ex) {
            throw new LogException(ErrorCodes.BAD_RESPONSE, "Unable to deserialize JSON to model: " + ex.getMessage(), ex, requestId);
        }
    }
}
