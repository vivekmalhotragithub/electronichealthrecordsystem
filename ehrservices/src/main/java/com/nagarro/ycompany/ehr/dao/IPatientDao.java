/**
 * 
 */
package com.nagarro.ycompany.ehr.dao;

import java.util.List;

import com.nagarro.ycompany.ehr.dao.entity.Patient;
import com.nagarro.ycompany.ehr.dto.PatientDTO;

/**
 * @author vivekmalhotra
 *
 */
public interface IPatientDao {

	public List<Patient> searchPatients(String name);

	public Patient createNewPatient(PatientDTO patientDTO);

}
