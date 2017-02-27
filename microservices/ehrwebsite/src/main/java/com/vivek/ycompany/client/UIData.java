package com.vivek.ycompany.client;

import java.util.List;

public class UIData {
	
	private SearchQuery searchQuery;
	private List<Doctor> doctors;
	
	

	public SearchQuery getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(SearchQuery searchQuery) {
		this.searchQuery = searchQuery;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	
}