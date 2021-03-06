package com.aliyun.aksls.chlde.log.common;

import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

import com.aliyun.aksls.chlde.log.http.client.HttpMethod;
import com.aliyun.aksls.chlde.log.util.JsonUtils;
import net.sf.json.JSONObject;

public class WebhookNotification extends HttpNotification {

    /**
     * Optional headers for http request.
     */
    @JSONField
    private Map<String, String> headers;

    /**
     * Optional method, default to POST.
     */
    @JSONField
    private HttpMethod method;

    public WebhookNotification() {
        super(NotificationType.WEBHOOK);
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public void deserialize(JSONObject value) {
        super.deserialize(value);
        String method = JsonUtils.readOptionalString(value, Consts.METHOD);
        if (method != null) {
            setMethod(HttpMethod.fromString(method));
        }
        setHeaders(JsonUtils.readOptionalMap(value, Consts.HEADERS));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        WebhookNotification
            that = (WebhookNotification) o;

        if (getMethod() != that.getMethod()) return false;
        return getHeaders() != null ? getHeaders().equals(that.getHeaders()) : that.getHeaders() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getMethod() != null ? getMethod().hashCode() : 0);
        result = 31 * result + (getHeaders() != null ? getHeaders().hashCode() : 0);
        return result;
    }
}
