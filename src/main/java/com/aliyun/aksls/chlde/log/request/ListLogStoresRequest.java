/*
 * Copyright (C) Alibaba Cloud Computing All rights reserved.
 */
package com.aliyun.aksls.chlde.log.request;

import com.aliyun.aksls.chlde.log.common.Consts;

/**
 * The request used to list log store from sls server
 * @author sls_dev
 *
 */
public class ListLogStoresRequest extends Request {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1380724751189149725L;
	

	
	public ListLogStoresRequest(String project, int offset, int size, String logstoreName)
	{
		super(project);
		SetOffset(offset);
		SetSize(size);
		SetLogstoreName(logstoreName);
	}
	

	public void SetOffset(int offset)
	{
		SetParam(Consts.CONST_OFFSET, String.valueOf(offset));
	}
	

	public void SetSize(int size)
	{
		SetParam(Consts.CONST_SIZE,String.valueOf(size));
	}

	public void SetLogstoreName(String logstoreName)
	{
		SetParam(Consts.CONST_LOGSTORE_NAME,logstoreName);
	}
}
