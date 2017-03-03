package com.vivek.ycompany.book.entity;

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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patient_Id")
	Patient patient;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="doctor_Id")
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
