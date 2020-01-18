package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.ShipperConfig;

public class GetShipperResponse extends Response {
	/**
	 * 
	 */
	private static final long serialVersionUID = -893143600187284633L;

	private ShipperConfig mConfig = null;
	
	public GetShipperResponse(Map<String, String> headers, ShipperConfig config) {
		super(headers);
		mConfig = config;
	}
	
	public ShipperConfig GetConfig()
	{
		return mConfig;
	}
	public void SetConfig(ShipperConfig config)
	{
		mConfig = config;
	}
}
