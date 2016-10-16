/**
 * 
 */
package com.nagarro.ycompany.ehr.dto;

import java.util.List;

/**
 * @author vivekmalhotra
 *
 */
public class AppointmentListDTO {
	
	private List<AppointmentDTO> appointmentList;

	/**
	 * @return the appointmentList
	 */
	public List<AppointmentDTO> getAppointmentList() {
		return appointmentList;
	}

	/**
	 * @param appointmentList the appointmentList to set
	 */
	public void setAppointmentList(List<AppointmentDTO> appointmentList) {
		this.appointmentList = appointmentList;
	}
	

}
