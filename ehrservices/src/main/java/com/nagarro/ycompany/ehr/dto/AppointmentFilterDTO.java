/**
 * 
 */
package com.nagarro.ycompany.ehr.dto;

/**
 * @author vivekmalhotra
 *
 */
public class AppointmentFilterDTO {
	
	private String doctor;
	
	private String patient;
	
	private String date;

	/**
	 * @return the doctor
	 */
	public String getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor the doctor to set
	 */
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return the patient
	 */
	public String getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(String patient) {
		this.patient = patient;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
