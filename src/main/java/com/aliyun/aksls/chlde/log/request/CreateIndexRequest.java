package com.aliyun.aksls.chlde.log.request;

import com.aliyun.aksls.chlde.log.common.Index;

public class CreateIndexRequest extends Request {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6178612655080198635L;
	private String logStore;
	private Index index;
	
	public CreateIndexRequest(String project, String logStore, Index index) {
		super(project);
		this.logStore = logStore;
		SetIndex(index);
	}

	/**
	 * @return the logStore
	 */
	public String GetLogStore() {
		return logStore;
	}

	/**
	 * @return the index
	 */
	public Index GetIndex() {
		return index;
	}

	/**
	 * @param logStore the logStore to set
	 */
	public void SetLogStore(String logStore) {
		this.logStore = logStore;
	}

	/**
	 * @param index the index to set
	 */
	public void SetIndex(Index index) {
		this.index = new Index(index);
	}

	
}
