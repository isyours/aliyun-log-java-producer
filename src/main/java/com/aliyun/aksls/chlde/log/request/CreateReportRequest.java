package com.aliyun.aksls.chlde.log.request;


import com.aliyun.aksls.chlde.log.common.Report;
import com.aliyun.aksls.chlde.log.util.Args;

public class CreateReportRequest extends CreateJobRequest {

    private static final long serialVersionUID = -2062295245187846869L;

    private Report report;

    public CreateReportRequest(String project, Report report) {
        super(project);
        Args.notNull(report, "report");
        this.report = report;
    }

    public Report getReport() {
        return report;
    }

    @Override
    public Object getBody() {
        return report;
    }
}
