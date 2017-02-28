package com.vivek.ycompany.client.dto;

public class Patient {

	long id;

	String gender;
	String fullName;
	String email;

	public Patient(String fullName, String email) {
		super();
		this.fullName = fullName;
		this.email = email;
	}

	public Patient() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", Full name=" + fullName + ", Gender="
				+ gender + ", Email=" + email + "]";
	}

}
