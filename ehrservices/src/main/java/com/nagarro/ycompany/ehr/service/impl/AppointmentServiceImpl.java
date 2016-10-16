/**
 * 
 */
package com.nagarro.ycompany.ehr.service.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.ycompany.ehr.dao.IAppointmentDao;
import com.nagarro.ycompany.ehr.dto.AppointmentDTO;
import com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO;
import com.nagarro.ycompany.ehr.service.IAppointmentService;

/**
 * @author vivekmalhotra
 *
 */
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
	public List<AppointmentDTO> searchAppointments(
			AppointmentFilterDTO filterDTO) {
		// TODO Auto-generated method stub
		return null;
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
