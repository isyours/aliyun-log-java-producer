package com.aliyun.aksls.chlde.log.request;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.Consts;
import com.aliyun.aksls.chlde.log.common.JobType;
import com.aliyun.aksls.chlde.log.http.client.HttpMethod;

public class ListJobsRequest extends JobRequest {

    private static final long serialVersionUID = -8772042308666861845L;

    /**
     * Display name for fuzzy matching.
     */
    private String displayName;

    /**
     * Job type for filtering
     */
    private JobType type;
    /**
     * resourceProvider for searching
     */
    private String resourceProvider;
    private String logstore;
    private Integer offset;
    private Integer size;

    public ListJobsRequest(String project) {
        super(project);
    }

    public ListJobsRequest(String project, JobType type) {
        super(project);
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public String getResourceProvider() {
        return resourceProvider;
    }

    public void setResourceProvider(String resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getLogstore() {
        return logstore;
    }

    public void setLogstore(String logstore) {
        this.logstore = logstore;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getUri() {
        return Consts.JOB_URI;
    }

    @Override
    public Map<String, String> GetAllParams() {
        final String name = getName();
        if (name != null && !name.isEmpty()) {
            SetParam(Consts.JOB_NAME, name);
        }
        if (displayName != null && !displayName.isEmpty()) {
            SetParam(Consts.DISPLAY_NAME, displayName);
        }
        if (type != null) {
            SetParam(Consts.JOB_TYPE, type.toString());
        }
        if (resourceProvider != null && !resourceProvider.isEmpty()) {
            SetParam(Consts.RESOURCE_PROVIDER, resourceProvider);
        }
        if (offset != null) {
            SetParam(Consts.CONST_OFFSET, offset.toString());
        }
        if (size != null) {
            SetParam(Consts.CONST_SIZE, size.toString());
        }
        if (logstore != null && !logstore.isEmpty()) {
            SetParam(Consts.LOGSTORE_KEY, logstore);
        }
        return super.GetAllParams();
    }
}
