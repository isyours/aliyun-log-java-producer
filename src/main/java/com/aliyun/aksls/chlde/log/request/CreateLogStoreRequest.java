package com.aliyun.aksls.chlde.log.request;

import com.aliyun.aksls.chlde.log.common.LogStore;

public class CreateLogStoreRequest extends Request {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7955483608406998461L;
	protected LogStore logStore = new LogStore();

	public CreateLogStoreRequest(String project, LogStore logStore) {
		super(project);
		SetLogStore(logStore);
	}
	
	public LogStore GetLogStore() {
		return logStore;
	}

	public void SetLogStore(LogStore logStore) {
		this.logStore = new LogStore(logStore);
	}
}
