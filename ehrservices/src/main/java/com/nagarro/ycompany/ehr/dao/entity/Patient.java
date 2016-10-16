package com.nagarro.ycompany.ehr.dao.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author vivekmalhotra
 *
 */
@Entity
@Table(name = "PATIENT")
public class Patient {

	private int patientId;
	
	private String fullName;
	
	private Date dateOfBirth;
	
	private String address;
	
	private String mobile;
	
	private String email;
	
	private String bloodGroup;
	
	private String gender;
	
	private List<PatientAppointment> appointmentList;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PATIENT_ID", unique = true, nullable = false)
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Column(name = "FULL_NAME", nullable = false)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "DATE_OF_BIRTH", nullable = false)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "MOBILE", nullable = false)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "EMAIL", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "BLOOD_GROUP", nullable = false)
	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Column(name = "GENDER", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the appointmentList
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	public List<PatientAppointment> getAppointmentList() {
		return appointmentList;
	}

	/**
	 * @param appointmentList the appointmentList to set
	 */
	public void setAppointmentList(List<PatientAppointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

}
