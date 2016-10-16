package com.nagarro.ycompany.ehr.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INTERNAL_USER")
public class InternalUser {

	private Integer userId;

	private String fullName;
	
	private List<PatientAppointment> appointmentList;

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setUserId(Integer id) {
		this.userId = id;
	}

	/**
	 * @return the fullName
	 */
	@Column(name = "FULL_NAME", nullable = false, length = 50)
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "Name:" + fullName;
	}
	
	/**
	 * @return the appointmentList
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalPractitioner")
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
