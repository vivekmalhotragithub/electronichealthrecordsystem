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

import com.nagarro.ycompany.ehr.dao.IPatientDao;
import com.nagarro.ycompany.ehr.dao.entity.Patient;
import com.nagarro.ycompany.ehr.dto.PatientDTO;
import com.nagarro.ycompany.ehr.dto.PatientSeachDTO;
import com.nagarro.ycompany.ehr.service.IPatientService;

/**
 * @author vivekmalhotra
 *
 */
@Service
public class PatientServiceImpl implements IPatientService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

	private IPatientDao patientDao;

	@Autowired
	DozerBeanMapper dozerBeanMapper;
	
	

	/**
	 * @param patientDao the patientDao to set
	 */
	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.ycompany.ehr.service.IPatientService#creatNewPatient(com.nagarro.ycompany.ehr.dto.PatientDTO)
	 */
	@Override
	public PatientDTO creatNewPatient(PatientDTO patientDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.nagarro.ycompany.ehr.service.IPatientService#searchPatients(java.lang.String)
	 */
	@Override
	@Transactional
	public List<PatientDTO> searchPatients(PatientSeachDTO searchFilter) {
		// search patients and return
		List<PatientDTO> patientDTOList = new ArrayList<>();
		List<Patient> patientList = patientDao.searchPatients(searchFilter);
		logger.info("calling patietDAO to filter patients based on search criteria");

		for(Patient patient : patientList){
			PatientDTO patientDTO = dozerBeanMapper.map(patient, PatientDTO.class,
					"ToPatientDTOSearchResult");
			patientDTOList.add(patientDTO);
		}
		
		return patientDTOList;
	}

}
