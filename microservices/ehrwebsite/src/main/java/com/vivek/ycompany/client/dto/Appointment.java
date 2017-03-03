package com.vivek.ycompany.client.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Appointment {

	long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date date;

	Doctor doctor;

	long patientId;

	String patientName;

	String patientEmail;
	
	String patientGender;

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

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", Date=" + date + ", Patient name="
				+ patientName + ",Patient email=" + patientEmail + ", Doctor="
				+ doctor + "]";
	}

}
