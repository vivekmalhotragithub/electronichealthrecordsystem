package com.vivek.ycompany.client;


public class Doctor {


	long id;

	String fullName;

	public Doctor() {
		super();
	}

	public Doctor(String fullName) {
		super();
		this.fullName = fullName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", Full Name=" + fullName + "]";
	}

}
