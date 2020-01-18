package com.aliyun.aksls.chlde.log.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

import com.aliyun.aksls.chlde.log.exception.LogException;

public class JsonConfigInputDetail extends LocalFileConfigInputDetail implements Serializable {

	private static final long serialVersionUID = 3566561287339580719L;
	private String timeKey = "";

	public JsonConfigInputDetail() {
		this.logType = Consts.CONST_CONFIG_LOGTYPE_JSON;
	}

	public JsonConfigInputDetail(String logPath,
			String filePattern,
			String timeKey,
			String timeFormat,
			boolean localStorage) {
		super();
		this.logType = Consts.CONST_CONFIG_LOGTYPE_JSON;
		this.logPath = logPath;
		this.filePattern = filePattern;
		this.timeKey = timeKey;
		this.timeFormat = timeFormat;
		this.localStorage = localStorage;
	}

	public String GetTimeKey() {
		return timeKey;
	}

	public void SetTimeKey(String timeKey) {
		this.timeKey = timeKey;
	}

	@Override
	public JSONObject ToJsonObject() {
		JSONObject jsonObj = new JSONObject();
		LocalFileConfigToJsonObject(jsonObj);
		jsonObj.put(Consts.CONST_CONFIG_INPUTDETAIL_TIMEKEY, timeKey);
		return jsonObj;
	}

	@Override
	public void FromJsonObject(JSONObject inputDetail) throws LogException {
		LocalFileConfigFromJsonObject(inputDetail);
		this.timeKey = inputDetail.getString(Consts.CONST_CONFIG_INPUTDETAIL_TIMEKEY);
	}

}
