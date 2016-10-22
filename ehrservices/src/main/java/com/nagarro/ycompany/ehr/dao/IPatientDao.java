/**
 * 
 */
package com.nagarro.ycompany.ehr.dao;

import java.util.List;

import com.nagarro.ycompany.ehr.dao.entity.Patient;
import com.nagarro.ycompany.ehr.dto.PatientDTO;
import com.nagarro.ycompany.ehr.dto.PatientSeachDTO;

/**
 * @author vivekmalhotra
 *
 */
public interface IPatientDao {

	/**
	 * Search for patients
	 * @param searchFilter
	 * @return
	 */
	public List<Patient> searchPatients(PatientSeachDTO searchFilter);

	/**
	 * Create a new patient
	 * @param patientDTO
	 * @return
	 */
	public Patient createNewPatient(PatientDTO patientDTO);

	/**
	 * Get patient details
	 * @param patientId
	 * @return
	 */
	public Patient getPatient(int patientId);

}
