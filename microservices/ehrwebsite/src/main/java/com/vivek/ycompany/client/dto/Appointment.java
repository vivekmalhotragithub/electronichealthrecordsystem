package com.vivek.ycompany.client.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class Appointment {

	long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date date;
	
	Patient patient;

	Doctor doctor;

	public Appointment() {
		super();
	}


	public Appointment(Date date, Patient patient,
			Doctor doctor) {
		super();
		this.date = date;
		this.patient = patient;
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


	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", Date=" + date + ", Patient=" + patient + ", Doctor=" + doctor + "]";
	}

 
	
	
}
