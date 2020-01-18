package com.aliyun.aksls.chlde.log.request;

import com.aliyun.aksls.chlde.log.common.LogStore;

public class UpdateLogStoreRequest extends Request {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2555582962386526246L;
	protected LogStore logStore = new LogStore();

	public UpdateLogStoreRequest(String project, LogStore logStore) {
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
