package com.aliyun.aksls.chlde.log.common;

import com.aliyun.aksls.chlde.log.exception.LogException;
import net.sf.json.JSONObject;

public interface ShipperConfig {

	String GetShipperType();
	
	JSONObject GetJsonObj();
	
	void FromJsonObj(JSONObject obj) throws LogException;

}
