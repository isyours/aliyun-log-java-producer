package com.aliyun.aksls.chlde.log.request;


import com.aliyun.aksls.chlde.log.common.Consts;
import com.aliyun.aksls.chlde.log.common.JobSchedule;
import com.aliyun.aksls.chlde.log.http.client.HttpMethod;
import com.aliyun.aksls.chlde.log.util.Args;

public class UpdateJobScheduleRequest extends BasicRequest {

    private static final long serialVersionUID = 4645953330661712600L;

    private final JobSchedule jobSchedule;

    public UpdateJobScheduleRequest(String project, JobSchedule schedule) {
        super(project);
        Args.notNull(schedule, "schedule");
        this.jobSchedule = schedule;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.PUT;
    }

    @Override
    public String getUri() {
        return Consts.JOB_SCHEDULE_URI + "/" + jobSchedule.getId();
    }

    @Override
    public Object getBody() {
        return jobSchedule;
    }
}
