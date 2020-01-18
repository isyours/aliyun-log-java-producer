package com.aliyun.aksls.chlde.log.response;

import java.util.Map;

import com.aliyun.aksls.chlde.log.common.SavedSearch;
import com.aliyun.aksls.chlde.log.exception.LogException;

public class GetSavedSearchResponse extends Response {

	private static final long serialVersionUID = 2530549032522820950L;
	protected SavedSearch savedSearch = new SavedSearch();

	public GetSavedSearchResponse(Map<String, String> headers, SavedSearch savedSearch) throws LogException {
		super(headers);
		setSavedSearch(savedSearch);
	}

	public SavedSearch getSavedSearch() {
		return savedSearch;
	}

	public void setSavedSearch(SavedSearch savedSearch) throws LogException {
		this.savedSearch = new SavedSearch(savedSearch);
	}

}
