package com.aliyun.aksls.chlde.log.request;

import com.aliyun.aksls.chlde.log.common.ETL;
import com.aliyun.aksls.chlde.log.http.client.HttpMethod;
import com.aliyun.aksls.chlde.log.util.Args;

public class UpdateETLRequest extends JobRequest {

    private static final long serialVersionUID = -6902986158715725606L;

    private ETL etl;

    public UpdateETLRequest(String project, ETL etl) {
        super(project);
        this.etl = etl;
        Args.notNull(etl, "ETL");
        setName(etl.getName());
    }

    public ETL getEtl() {
        return etl;
    }

    public void setEtl(ETL etl) {
        this.etl = etl;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.PUT;
    }

    @Override
    public Object getBody() {
        return etl;
    }
}
