/**
 * 
 */
package com.nagarro.ycompany.ehr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.ycompany.ehr.dao.IAppointmentDao;
import com.nagarro.ycompany.ehr.dao.IPatientDao;
import com.nagarro.ycompany.ehr.dao.IUserAuthenticationDao;
import com.nagarro.ycompany.ehr.dao.entity.Patient;
import com.nagarro.ycompany.ehr.dao.entity.PatientAppointment;
import com.nagarro.ycompany.ehr.dao.entity.UserCredential;
import com.nagarro.ycompany.ehr.dto.AppointmentDTO;
import com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO;
import com.nagarro.ycompany.ehr.service.IAppointmentService;

/**
 * @author vivekmalhotra
 *
 */
@Service
public class AppointmentServiceImpl implements IAppointmentService {

	private static final Logger logger = LoggerFactory
			.getLogger(AppointmentServiceImpl.class);

	private IAppointmentDao appointmentDao;

	private IPatientDao patientDao;

	private IUserAuthenticationDao userAuthenticationDao;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	/**
	 * @param appointmentDao
	 *            the appointmentDao to set
	 */
	public void setAppointmentDao(IAppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}

	/**
	 * @param patientDao
	 *            the patientDao to set
	 */
	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}

	/**
	 * @param userAuthenticationDao the userAuthenticationDao to set
	 */
	public void setUserAuthenticationDao(
			IUserAuthenticationDao userAuthenticationDao) {
		this.userAuthenticationDao = userAuthenticationDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagarro.ycompany.ehr.service.IAppointmentService#searchAppointments
	 * (com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO)
	 */
	@Override
	@Transactional
	public List<AppointmentDTO> searchAppointments(
			AppointmentFilterDTO filterDTO) {
		//
		List<AppointmentDTO> appointDTOList = new ArrayList<>();
		List<PatientAppointment> appointmentList = appointmentDao
				.searchAppointments(filterDTO);

		for (PatientAppointment appointment : appointmentList) {
			AppointmentDTO appointDTO = dozerBeanMapper.map(appointment,
					AppointmentDTO.class, "ToAppointmentDTOSearchResult");
			appointDTOList.add(appointDTO);
		}

		return appointDTOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagarro.ycompany.ehr.service.IAppointmentService#bookNewAppointment
	 * (com.nagarro.ycompany.ehr.dto.AppointmentDTO)
	 */
	@Override
	@Transactional
	public Integer bookNewAppointment(AppointmentDTO appointmentDTO) {
		// book new appointment
		PatientAppointment appointment = new PatientAppointment();
		
		//get patient
		Patient patient = patientDao.getPatient(appointmentDTO.getPatientId());
		if (patient != null) {
			appointment.setPatient(patient);
		}

		// get doctor
		UserCredential credential = userAuthenticationDao
				.getUserByUsername(appointmentDTO.getMedicalPractitioner());
		if (credential != null) {
			appointment.setMedicalPractitioner(credential);
		}
		// appointment Date
		appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
		
		// comments
		appointment.setComments(appointmentDTO.getComments());

		Integer appointmentId = appointmentDao.saveAppointment(appointment);
		logger.info("create new appointment with id:" + appointmentId);
		return appointmentId;
	}

	@Override
	@Transactional
	public AppointmentDTO getAppointment(int appointmentId) {
		// get appointment based on id
		PatientAppointment appointment = appointmentDao
				.getAppointment(appointmentId);
		AppointmentDTO appointDTO = dozerBeanMapper.map(appointment,
				AppointmentDTO.class);
		logger.info("appointment found:" + appointDTO);
		return appointDTO;
	}

}
