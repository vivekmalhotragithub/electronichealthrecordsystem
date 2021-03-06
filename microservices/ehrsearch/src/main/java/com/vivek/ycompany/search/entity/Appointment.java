package com.vivek.ycompany.search.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Appointment {

	@Id
	long id;

	Date date;

	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name="patient_Id")
	// Patient patient;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_Id")
	Doctor doctor;

	long patientId;

	String patientName;

	String patientEmail;

	public Appointment() {
		super();
	}

	public Appointment(Date date, Doctor doctor) {
		super();
		this.date = date;
		this.doctor = doctor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", Date=" + date + ", Patient="
				+ patientName + ",Patient email=" + patientEmail + ", Doctor="
				+ doctor + "]";
	}

}
