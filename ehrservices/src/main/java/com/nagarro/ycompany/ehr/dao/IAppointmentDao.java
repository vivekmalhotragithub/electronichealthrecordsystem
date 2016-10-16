package com.nagarro.ycompany.ehr.dao;

import java.util.List;

import com.nagarro.ycompany.ehr.dao.entity.PatientAppointment;
import com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO;

public interface IAppointmentDao {

	List<PatientAppointment> searchAppointments(AppointmentFilterDTO filterDTO);

}
