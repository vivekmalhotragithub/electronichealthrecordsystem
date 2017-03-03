package com.vivek.ycompany.book.dto;


public class DoctorDTO {


	long id;

	String fullName;

	public DoctorDTO() {
		super();
	}

	public DoctorDTO(String fullName) {
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
