/**
 * 
 */
package com.nagarro.ycompany.ehr.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.ycompany.ehr.dao.IAppointmentDao;
import com.nagarro.ycompany.ehr.dao.entity.PatientAppointment;
import com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO;

/**
 * @author vivekmalhotra
 *
 */
@Repository
@Transactional
public class AppointmentDaoImpl implements IAppointmentDao {
	

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.ycompany.ehr.dao.IAppointmentDao#searchAppointments(com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO)
	 */
	@Override
	public List<PatientAppointment> searchAppointments(
			AppointmentFilterDTO filterDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
