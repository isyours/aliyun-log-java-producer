package com.aliyun.aksls.chlde.log.request;

import com.aliyun.aksls.chlde.log.common.Consts;
import com.aliyun.aksls.chlde.log.http.client.HttpMethod;

/**
 * Disable job request.
 */
public class DisableJobRequest extends JobRequest {

    private static final long serialVersionUID = 9008431160488152118L;

    public DisableJobRequest(String project, String jobName) {
        super(project, jobName);
        SetParam(Consts.ACTION, Consts.DISABLE);
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.PUT;
    }
}
