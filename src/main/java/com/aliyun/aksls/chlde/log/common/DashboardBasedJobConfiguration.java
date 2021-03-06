package com.aliyun.aksls.chlde.log.common;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import com.aliyun.aksls.chlde.log.internal.Unmarshaller;
import com.aliyun.aksls.chlde.log.util.JsonUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

abstract class DashboardBasedJobConfiguration extends JobConfiguration {

    @JSONField
    private String dashboard;

    @JSONField
    private List<Notification> notificationList;

    public String getDashboard() {
        return dashboard;
    }

    public void setDashboard(String dashboard) {
        this.dashboard = dashboard;
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    abstract Notification makeQualifiedNotification(NotificationType type);

    @Override
    public void deserialize(JSONObject value) {
        dashboard = value.getString("dashboard");
        notificationList = JsonUtils.readList(value, "notificationList", new Unmarshaller<Notification>() {
            @Override
            public Notification unmarshal(JSONArray value, int index) {
                JSONObject item = value.getJSONObject(index);
                NotificationType notificationType = NotificationType.fromString(item.getString("type"));
                Notification notification = makeQualifiedNotification(notificationType);
                notification.deserialize(item);
                return notification;
            }
        });
    }
}
