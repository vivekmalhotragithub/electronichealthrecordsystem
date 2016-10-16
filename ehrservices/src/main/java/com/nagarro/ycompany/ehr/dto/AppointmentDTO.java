/**
 * 
 */
package com.nagarro.ycompany.ehr.dto;

import java.util.Date;

/**
 * @author vivekmalhotra
 *
 */
public class AppointmentDTO {
	
	private int appointmentId;
	
	private String patientName;
	
	private Date appointmentDate;
	
	private String medicalPractitioner;

	/**
	 * @return the appointmentId
	 */
	public int getAppointmentId() {
		return appointmentId;
	}

	/**
	 * @param appointmentId the appointmentId to set
	 */
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return the appointmentDate
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate the appointmentDate to set
	 */
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	/**
	 * @return the medicalpractitioner
	 */
	public String getMedicalPractitioner() {
		return medicalPractitioner;
	}

	/**
	 * @param medicalpractitioner the medicalpractitioner to set
	 */
	public void setMedicalPractitioner(String medicalpractitioner) {
		this.medicalPractitioner = medicalpractitioner;
	}
	

}
