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
	
	private int patientId;
	
	private String patientName;
	
	private String patientAddress;
	
	private String patientMobile;

	private Date appointmentDate;

	private String medicalPractitioner;
	
	private String comments;

	/**
	 * @return the appointmentId
	 */
	public int getAppointmentId() {
		return appointmentId;
	}

	/**
	 * @param appointmentId
	 *            the appointmentId to set
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
	 * @param patientName
	 *            the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the patientAddress
	 */
	public String getPatientAddress() {
		return patientAddress;
	}

	/**
	 * @param patientAddress the patientAddress to set
	 */
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	/**
	 * @return the patientMobile
	 */
	public String getPatientMobile() {
		return patientMobile;
	}

	/**
	 * @param patientMobile the patientMobile to set
	 */
	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}

	/**
	 * @return the appointmentDate
	 */
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @param appointmentDate
	 *            the appointmentDate to set
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
	 * @param medicalpractitioner
	 *            the medicalpractitioner to set
	 */
	public void setMedicalPractitioner(String medicalpractitioner) {
		this.medicalPractitioner = medicalpractitioner;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AppointmentDTO [appointmentId=" + appointmentId
				+ ", patientName=" + patientName + ", appointmentDate="
				+ appointmentDate + ", medicalPractitioner="
				+ medicalPractitioner + "]";
	}

}
