package com.aliyun.aksls.chlde.log.request;


import com.aliyun.aksls.chlde.log.common.Consts;
import com.aliyun.aksls.chlde.log.common.ETL;
import com.aliyun.aksls.chlde.log.http.client.HttpMethod;
import com.aliyun.aksls.chlde.log.util.Args;

public class CreateETLRequest extends JobRequest {

    private static final long serialVersionUID = 3346010323520068092L;

    private ETL etl;

    public CreateETLRequest(String project, ETL etl) {
        super(project);
        Args.notNull(etl, "ETL");
        this.etl = etl;
    }

    public ETL getEtl() {
        return etl;
    }

    public void setEtl(ETL etl) {
        this.etl = etl;
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
        return etl;
    }
}
