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
import com.nagarro.ycompany.ehr.dao.entity.PatientAppointment;
import com.nagarro.ycompany.ehr.dto.AppointmentDTO;
import com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO;
import com.nagarro.ycompany.ehr.service.IAppointmentService;

/**
 * @author vivekmalhotra
 *
 */
@Service
public class AppointmentServiceImpl implements IAppointmentService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceImpl.class);

	private IAppointmentDao appointmentDao;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	/**
	 * @param appointmentDao the appointmentDao to set
	 */
	public void setAppointmentDao(IAppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.ycompany.ehr.service.IAppointmentService#searchAppointments(com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO)
	 */
	@Override
	@Transactional
	public List<AppointmentDTO> searchAppointments(
			AppointmentFilterDTO filterDTO) {
		// 
		List<AppointmentDTO> appointDTOList = new ArrayList<>();
		List<PatientAppointment> appointmentList = appointmentDao.searchAppointments(filterDTO);
		
		for(PatientAppointment appointment : appointmentList){
			AppointmentDTO appointDTO = dozerBeanMapper.map(appointment, AppointmentDTO.class,
					"ToAppointmentDTOSearchResult");
			appointDTOList.add(appointDTO);
		}
		
		return appointDTOList;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.ycompany.ehr.service.IAppointmentService#bookNewAppointment(com.nagarro.ycompany.ehr.dto.AppointmentDTO)
	 */
	@Override
	public AppointmentDTO bookNewAppointment(AppointmentDTO appointmentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
