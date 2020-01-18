package com.aliyun.aksls.chlde.log.common;

import com.aliyun.aksls.chlde.log.exception.LogException;
import net.sf.json.JSONObject;

public abstract class OssShipperStorageDetail {
	private String mStorageFormat = "";
	
	public String getmStorageFormat() {
		return mStorageFormat;
	}
	public void setmStorageFormat(String mStorageFormat) {
		this.mStorageFormat = mStorageFormat;
	}
	public abstract JSONObject ToJsonObject();
	public abstract void FromJsonObject(JSONObject inputDetail) throws LogException;
}