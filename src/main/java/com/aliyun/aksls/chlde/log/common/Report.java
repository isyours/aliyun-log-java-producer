package com.aliyun.aksls.chlde.log.common;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

import net.sf.json.JSONObject;

public class Report extends ScheduledJob implements Serializable {

    private static final long serialVersionUID = 9211926785430833230L;

    @JSONField
    private ReportConfiguration configuration;

    public Report() {
        setType(JobType.REPORT);
    }

    @Override
    public ReportConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(ReportConfiguration configuration) {
        this.configuration = configuration;
    }

    public void deserialize(JSONObject value) {
        super.deserialize(value);
        configuration = new ReportConfiguration();
        configuration.deserialize(value.getJSONObject("configuration"));
    }
}
