package com.aliyun.aksls.chlde.log.request;

import com.aliyun.aksls.chlde.log.common.Consts;
import com.aliyun.aksls.chlde.log.util.Args;

public abstract class JobRequest extends BasicRequest {

    private String name;

    public JobRequest(String project) {
        super(project);
    }

    public JobRequest(String project, String name) {
        super(project);
        Args.notNullOrEmpty(name, "name");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return Consts.JOB_URI + "/" + name;
    }
}
