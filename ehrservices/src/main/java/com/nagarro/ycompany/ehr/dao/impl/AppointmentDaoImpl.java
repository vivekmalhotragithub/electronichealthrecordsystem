/**
 * 
 */
package com.nagarro.ycompany.ehr.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
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
	@SuppressWarnings("unchecked")
	@Override
	public List<PatientAppointment> searchAppointments(
			AppointmentFilterDTO filterDTO) {
		// get appointments
		
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(PatientAppointment.class);
		if(filterDTO.getDoctor() != null){
			criteria.createAlias("medicalPractitioner", "practitioner");
			criteria.add(Restrictions.eq("practitioner.username", filterDTO.getDoctor()));
			
		}
		return criteria.list();
	}

}
