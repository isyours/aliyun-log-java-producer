package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.ETL;
import com.aliyun.aksls.chlde.log.exception.LogException;
import com.aliyun.aksls.chlde.log.internal.ErrorCodes;
import net.sf.json.JSONObject;

public class GetETLResponse extends Response {

    private static final long serialVersionUID = 889623903109968396L;

    private ETL etl;

    public GetETLResponse(Map<String, String> headers) {
        super(headers);
    }

    public ETL getEtl() {
        return etl;
    }

    public void setEtl(ETL etl) {
        this.etl = etl;
    }

    public void deserialize(JSONObject value, String requestId) throws LogException {
        etl = new ETL();
        try {
            etl.deserialize(value);
        } catch (final Exception ex) {
            throw new LogException(ErrorCodes.BAD_RESPONSE, "Unable to deserialize JSON to model: " + ex.getMessage(), ex, requestId);
        }
    }
}
