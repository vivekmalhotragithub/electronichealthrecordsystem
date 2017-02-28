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

    
	public Patient(String fullName,String email) {
		super();
		this.fullName = fullName;
		this.email = email;
	}

	public Patient() {
		super();
	}

 
	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", Full name=" + fullName + ", Email=" + email + "]";
	}
    
    
}
