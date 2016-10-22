package com.nagarro.ycompany.ehr.dao;

import java.util.List;

import com.nagarro.ycompany.ehr.dao.entity.PatientAppointment;
import com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO;

public interface IAppointmentDao {

	/**
	 * List appointment based on filter criteria
	 * 
	 * @param filterDTO
	 * @return
	 */
	List<PatientAppointment> searchAppointments(AppointmentFilterDTO filterDTO);

	/**
	 * get appointment based on appointment id
	 * 
	 * @param appointmentId
	 * @return
	 */
	PatientAppointment getAppointment(int appointmentId);

	/**
	 * Save appointment
	 * 
	 * @param appointment
	 * @return Integer
	 */
	Integer saveAppointment(PatientAppointment appointment);

}
