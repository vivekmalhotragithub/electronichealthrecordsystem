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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.ycompany.ehr.dto.AppointmentDTO;
import com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO;
import com.nagarro.ycompany.ehr.dto.AppointmentListDTO;
import com.nagarro.ycompany.ehr.service.impl.AppointmentServiceImpl;

/**
 * @author vivekmalhotra
 *
 */
@Controller
@RequestMapping(value = "/doctor/*")
public class DoctorController {

	@Autowired
	@Qualifier(value = "appointmentService")
	private AppointmentServiceImpl appointmentService;

	private static final Logger logger = LoggerFactory
			.getLogger(DoctorController.class);

	/**
	 * method to display dao
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome(Model model) {
		logger.info("Welcome to Doctor's Dashboard page");
		ModelAndView mv = new ModelAndView("dashboard");
		mv.addObject("name", getPrincipal());
		return mv;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appointment/new", method = RequestMethod.GET)
	public ModelAndView bookApointment(Model model) {
		logger.info("user requested to book an appointment");
		ModelAndView mv = new ModelAndView("bookappointment");
		mv.addObject("name", getPrincipal());
		return mv;
	}

	// get the current user from Security context
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	/**
	 * 
	 * @param model
	 * @param filterDTO
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appointment/list", method = RequestMethod.POST)
	public @ResponseBody AppointmentListDTO getAllAppointments(
			AppointmentFilterDTO filterDTO, HttpServletRequest request)
			throws Exception {
		AppointmentListDTO appointlistDTO = new AppointmentListDTO();

		List<AppointmentDTO> appointmentList = appointmentService
				.searchAppointments(filterDTO);

		appointlistDTO.setAppointmentList(appointmentList);

		return appointlistDTO;
	}

}
