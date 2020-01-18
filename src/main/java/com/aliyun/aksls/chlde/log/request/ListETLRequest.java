package com.aliyun.aksls.chlde.log.request;

import java.io.Serializable;

import com.aliyun.aksls.chlde.log.common.JobType;

public class ListETLRequest extends ListJobsRequest implements Serializable {

    private static final long serialVersionUID = 1109698724031406237L;

    public ListETLRequest(String project) {
        super(project, JobType.ETL);
    }
}
