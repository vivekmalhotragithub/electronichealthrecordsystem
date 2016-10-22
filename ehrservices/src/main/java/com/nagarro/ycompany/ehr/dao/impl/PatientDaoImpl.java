/**
 * 
 */
package com.nagarro.ycompany.ehr.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.nagarro.ycompany.ehr.dao.IPatientDao;
import com.nagarro.ycompany.ehr.dao.entity.Patient;
import com.nagarro.ycompany.ehr.dto.PatientDTO;
import com.nagarro.ycompany.ehr.dto.PatientSeachDTO;

/**
 * @author vivekmalhotra
 *
 */
public class PatientDaoImpl implements IPatientDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagarro.ycompany.ehr.dao.IPatientDao#searchPatients(java.lang.String)
	 */
	@Override
	public List<Patient> searchPatients(PatientSeachDTO searchFilter) {
		// 

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Patient.class);
		if(searchFilter.getPatientName() != null){
			criteria.add(Restrictions.like("fullName", "%"+searchFilter.getPatientName()+"%"));
			
		}
		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nagarro.ycompany.ehr.dao.IPatientDao#createNewPatient(com.nagarro
	 * .ycompany.ehr.dto.PatientDTO)
	 */
	@Override
	public Patient createNewPatient(PatientDTO patientDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatient(int patientId) {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Patient.class);
		criteria.add(Restrictions.eq("patientId", patientId));
		return (Patient) criteria.uniqueResult();
	}

}
