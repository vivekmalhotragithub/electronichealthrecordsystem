/**
 * 
 */
package com.nagarro.ycompany.ehr.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.nagarro.ycompany.ehr.dao.IPatientDao;
import com.nagarro.ycompany.ehr.dao.entity.Patient;
import com.nagarro.ycompany.ehr.dto.PatientDTO;

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
	public List<Patient> searchPatients(String name) {
		// TODO Auto-generated method stub
		return null;
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

}
