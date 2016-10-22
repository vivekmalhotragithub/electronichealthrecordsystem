/**
 * 
 */
package com.nagarro.ycompany.ehr.service;

import java.util.List;

import com.nagarro.ycompany.ehr.dto.AppointmentDTO;
import com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO;

/**
 * @author vivekmalhotra
 *
 */
public interface IAppointmentService {

	/**
	 * search for appointments
	 * 
	 * @param filterDTO
	 * @return
	 */
	List<AppointmentDTO> searchAppointments(AppointmentFilterDTO filterDTO);

	/**
	 * Create a new appointment
	 * 
	 * @param appointmentDTO
	 * @return Integer
	 */
	Integer bookNewAppointment(AppointmentDTO appointmentDTO);

	/**
	 * Get an appointment based on appointment id
	 * 
	 * @param appointmentId
	 * @return
	 */
	AppointmentDTO getAppointment(int appointmentId);

}
