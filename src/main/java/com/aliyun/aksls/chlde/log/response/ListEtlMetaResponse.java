package com.aliyun.aksls.chlde.log.response;

import java.util.ArrayList;
import java.util.Map;

import com.aliyun.aksls.chlde.log.common.EtlMeta;

public class ListEtlMetaResponse extends Response {

    private static final long serialVersionUID = 6910928417094933294L;
    protected ArrayList<EtlMeta> etlMetaList = new ArrayList<EtlMeta>();
    protected int total;

    public ListEtlMetaResponse(Map<String, String> headers, int total) {
        super(headers);
        this.total = total;
    }

    public void addEtlMeta(EtlMeta etlMeta) {
        this.etlMetaList.add(etlMeta);
    }

    public ArrayList<EtlMeta> getEtlMetaList() {
        return etlMetaList;
    }

    public EtlMeta getHeadEtlMeta() {
        if (this.etlMetaList.size() > 0) {
            return this.etlMetaList.get(0);
        } else {
            return null;
        }
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return this.etlMetaList.size();
    }
}
