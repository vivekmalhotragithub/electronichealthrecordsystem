/**
 * 
 */
package com.nagarro.ycompany.ehr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.ycompany.ehr.dto.PatientDTO;
import com.nagarro.ycompany.ehr.dto.PatientListDTO;
import com.nagarro.ycompany.ehr.dto.PatientSeachDTO;
import com.nagarro.ycompany.ehr.service.IPatientService;

/**
 * @author vivekmalhotra
 *
 */
@Controller
@RequestMapping(value = "/patient/*")
public class PatientController {

	@Autowired
	@Qualifier(value = "patientService")
	private IPatientService patientService;

	private static final Logger logger = LoggerFactory
			.getLogger(PatientController.class);

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody PatientListDTO SearchPatients(
			@RequestBody PatientSeachDTO filterDTO, HttpServletRequest request)
			throws Exception {
		PatientListDTO patientlistDTO = new PatientListDTO();

		List<PatientDTO> patientList = patientService.searchPatients(filterDTO);

		patientlistDTO.setPatientList(patientList);
		logger.info("patient list found: " + patientlistDTO);

		return patientlistDTO;
	}

}
