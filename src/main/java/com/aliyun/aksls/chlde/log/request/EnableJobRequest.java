package com.aliyun.aksls.chlde.log.request;


import com.aliyun.aksls.chlde.log.common.Consts;
import com.aliyun.aksls.chlde.log.http.client.HttpMethod;

/**
 * Enable job request.
 */
public class EnableJobRequest extends JobRequest {

    private static final long serialVersionUID = 2230629908477976493L;

    public EnableJobRequest(String project, String jobName) {
        super(project, jobName);
        SetParam(Consts.ACTION, Consts.ENABLE);
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.PUT;
    }
}
