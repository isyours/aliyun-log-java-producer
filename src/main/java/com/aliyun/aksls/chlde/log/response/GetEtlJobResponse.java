package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.EtlJob;

public class GetEtlJobResponse extends Response {

    private static final long serialVersionUID = -1358283804315034924L;
    protected EtlJob etljob;

    public EtlJob getEtljob() {
        return etljob;
    }

    public void setEtljob(EtlJob etljob) {
        this.etljob = etljob;
    }

    public GetEtlJobResponse(Map<String, String> headers, EtlJob etlJob) {
        super(headers);
        this.etljob = etlJob;
    }
}
