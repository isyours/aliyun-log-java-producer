package com.aliyun.aksls.chlde.log.request;

import com.aliyun.aksls.chlde.log.common.SavedSearch;
import com.aliyun.aksls.chlde.log.exception.LogException;

public class CreateSavedSearchRequest extends Request {

	private static final long serialVersionUID = -2075352399745773362L;
	protected SavedSearch savedSearch = new SavedSearch();

	public CreateSavedSearchRequest(String project, SavedSearch savedSearch) {
		super(project);
		this.savedSearch = savedSearch;
	}
	
	public SavedSearch getSavedSearch() {
		return this.savedSearch;
	}

	public void setSavedSearch(SavedSearch savedSearch) throws LogException {
		this.savedSearch = new SavedSearch(savedSearch);
	}

}
