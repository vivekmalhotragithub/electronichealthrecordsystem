package com.vivek.ycompany.client;

import java.util.List;

import com.vivek.ycompany.client.dto.Appointment;
import com.vivek.ycompany.client.dto.Doctor;

public class UIData {
	
	private SearchQuery searchQuery;
	private List<Doctor> doctors;
	private List<Appointment> appointments;
	private Appointment newAppointment;
	
	public SearchQuery getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(SearchQuery searchQuery) {
		this.searchQuery = searchQuery;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment getNewAppointment() {
		return newAppointment;
	}

	public void setNewAppointment(Appointment newAppointment) {
		this.newAppointment = newAppointment;
	}

	
}