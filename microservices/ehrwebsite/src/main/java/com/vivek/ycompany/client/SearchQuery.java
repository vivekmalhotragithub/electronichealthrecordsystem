package com.vivek.ycompany.client;
 

public class SearchQuery {
	String doctor;
	
	
	public SearchQuery() {
		super();
	}


	@Override
	public String toString() {
		return "SearchQuery [doctor=" + doctor + "]";
	}


	public SearchQuery(String doctor) {
		super();
		this.doctor = doctor;
	}
	
	
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	
}