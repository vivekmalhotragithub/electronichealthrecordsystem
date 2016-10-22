/**
 * 
 */
package com.nagarro.ycompany.ehr.service;

import java.util.List;

import com.nagarro.ycompany.ehr.dto.PatientDTO;
import com.nagarro.ycompany.ehr.dto.PatientSeachDTO;

/**
 * @author vivekmalhotra
 *
 */
public interface IPatientService {
	
	/**
	 * service to create a new patient
	 * @param patientDTO
	 * @return
	 */
	PatientDTO creatNewPatient(PatientDTO patientDTO);
	
	/**
	 * service to search patients and return a list
	 * @param patientName
	 * @return
	 */
	List<PatientDTO> searchPatients(PatientSeachDTO searchFilter);

}
