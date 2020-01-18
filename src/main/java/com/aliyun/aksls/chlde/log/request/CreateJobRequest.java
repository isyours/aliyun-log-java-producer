package com.aliyun.aksls.chlde.log.request;


import com.aliyun.aksls.chlde.log.common.Consts;
import com.aliyun.aksls.chlde.log.common.Job;
import com.aliyun.aksls.chlde.log.http.client.HttpMethod;
import com.aliyun.aksls.chlde.log.util.Args;

@Deprecated
public class CreateJobRequest extends JobRequest {

    private static final long serialVersionUID = -7991351821489008819L;

    private Job job;

    CreateJobRequest(String project) {
        super(project);
    }

    public CreateJobRequest(String project, Job job) {
        super(project);
        setJob(job);
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        Args.notNull(job, "Job");
        this.job = job;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }

    @Override
    public String getUri() {
        return Consts.JOB_URI;
    }

    @Override
    public Object getBody() {
        return job;
    }
}
