package com.vivek.ycompany.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "patient_id")
	long id;
    
    String fullName;
    
    @Column(name = "email", unique=true)
    String email;
    
    String gender;

    
	public Patient(String fullName,String email, String gender) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.gender = gender;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", Full name=" + fullName + ", Email=" + email + "]";
	}
    
    
}
