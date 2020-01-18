package com.aliyun.aksls.chlde.log.response;

import java.io.Serializable;
import java.util.Map;

import com.aliyun.aksls.chlde.log.common.Report;
import com.aliyun.aksls.chlde.log.internal.Unmarshaller;
import net.sf.json.JSONArray;

public class ListReportResponse extends ResponseList<Report> implements Serializable {

    private static final long serialVersionUID = 8292912274110714070L;

    public ListReportResponse(Map<String, String> headers) {
        super(headers);
    }

    @Override
    public Unmarshaller<Report> unmarshaller() {
        return new Unmarshaller<Report>() {
            @Override
            public Report unmarshal(JSONArray value, int index) {
                Report report = new Report();
                report.deserialize(value.getJSONObject(index));
                return report;
            }
        };
    }
}
