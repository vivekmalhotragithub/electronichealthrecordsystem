/**
 * 
 */
package com.nagarro.ycompany.ehr.dto;

import java.util.List;



/**
 * @author vivekmalhotra
 *
 */
public class PatientListDTO {
	
	
	List<PatientDTO> patientList;

	/**
	 * @return the patientList
	 */
	public List<PatientDTO> getPatientList() {
		return patientList;
	}

	/**
	 * @param patientList the patientList to set
	 */
	public void setPatientList(List<PatientDTO> patientList) {
		this.patientList = patientList;
	}

}
