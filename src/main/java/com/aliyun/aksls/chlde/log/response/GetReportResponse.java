package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.Report;
import com.aliyun.aksls.chlde.log.exception.LogException;
import com.aliyun.aksls.chlde.log.internal.ErrorCodes;
import net.sf.json.JSONObject;

public class GetReportResponse extends Response {

    private static final long serialVersionUID = 3039200816847354835L;

    private Report report;

    public GetReportResponse(Map<String, String> headers) {
        super(headers);
    }

    public Report getReport() {
        return report;
    }

    public void deserialize(JSONObject value, final String requestId) throws LogException {
        report = new Report();
        try {
            report.deserialize(value);
        } catch (final Exception ex) {
            throw new LogException(ErrorCodes.BAD_RESPONSE, "Unable to deserialize JSON to model: " + ex.getMessage(), ex, requestId);
        }
    }
}
