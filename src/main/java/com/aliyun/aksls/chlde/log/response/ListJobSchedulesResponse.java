package com.aliyun.aksls.chlde.log.response;

import java.io.Serializable;
import java.util.Map;

import com.aliyun.aksls.chlde.log.common.JobSchedule;
import com.aliyun.aksls.chlde.log.internal.Unmarshaller;
import net.sf.json.JSONArray;

public class ListJobSchedulesResponse extends ResponseList<JobSchedule> implements Serializable {

    private static final long serialVersionUID = 2584488640627126067L;

    public ListJobSchedulesResponse(Map<String, String> headers) {
        super(headers);
    }

    @Override
    public Unmarshaller<JobSchedule> unmarshaller() {
        return new Unmarshaller<JobSchedule>() {
            @Override
            public JobSchedule unmarshal(JSONArray value, int index) {
                JobSchedule model = new JobSchedule();
                model.deserialize(value.getJSONObject(index));
                return model;
            }
        };
    }
}
