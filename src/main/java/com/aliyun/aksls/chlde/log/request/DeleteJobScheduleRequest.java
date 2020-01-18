package com.aliyun.aksls.chlde.log.request;


import com.aliyun.aksls.chlde.log.common.Consts;
import com.aliyun.aksls.chlde.log.http.client.HttpMethod;

public class DeleteJobScheduleRequest extends BasicRequest {

    private static final long serialVersionUID = 5653914929124984368L;
    private String jobScheduleId;

    public DeleteJobScheduleRequest(String project, String jobScheduleId) {
        super(project);
        this.jobScheduleId = jobScheduleId;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.DELETE;
    }

    @Override
    public String getUri() {
        return Consts.JOB_SCHEDULE_URI + "/" + jobScheduleId;
    }
}
