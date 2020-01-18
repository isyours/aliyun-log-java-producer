package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.Logging;
import com.aliyun.aksls.chlde.log.util.Args;

public class GetLoggingResponse extends Response {

    private Logging logging;

    /**
     * Construct a new {@link GetLoggingResponse} instance.
     *
     * @param headers The response headers.
     */
    public GetLoggingResponse(Map<String, String> headers, Logging logging) {
        super(headers);
        setLogging(logging);
    }

    public Logging getLogging() {
        return logging;
    }

    public void setLogging(Logging logging) {
        Args.notNull(logging, "logging");
        this.logging = logging;
    }
}
