/**
 * 
 */
package com.nagarro.ycompany.ehr.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author vivekmalhotra
 *
 */

@Entity
@Table(name = "PATIENT_APPOINTMENT")
public class PatientAppointment {
		
	private int appointmentId;
	
	private Patient patient;
	
	private InternalUser medicalPractitioner;

	/**
	 * @return the appointmentId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPOINTMENT_ID", unique = true, nullable = false)
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
	 * @return the patient
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID", nullable = false)
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the medicalPractitioner
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public InternalUser getMedicalPractitioner() {
		return medicalPractitioner;
	}

	/**
	 * @param medicalPractitioner the medicalPractitioner to set
	 */
	public void setMedicalPractitioner(InternalUser medicalPractitioner) {
		this.medicalPractitioner = medicalPractitioner;
	}
	
	
	
	
}
