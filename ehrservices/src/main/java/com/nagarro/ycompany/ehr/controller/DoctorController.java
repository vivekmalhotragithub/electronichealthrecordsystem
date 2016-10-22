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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.ycompany.ehr.dto.AppointmentDTO;
import com.nagarro.ycompany.ehr.dto.AppointmentFilterDTO;
import com.nagarro.ycompany.ehr.dto.AppointmentListDTO;
import com.nagarro.ycompany.ehr.service.IAppointmentService;
import com.nagarro.ycompany.ehr.service.ILoginService;

/**
 * @author vivekmalhotra
 *
 */
@Controller
@RequestMapping(value = "/doctor/*")
public class DoctorController {

	@Autowired
	@Qualifier(value = "appointmentService")
	private IAppointmentService appointmentService;

	@Autowired
	private ILoginService loginService;

	private static final Logger logger = LoggerFactory
			.getLogger(DoctorController.class);

	/**
	 * method to display dashboard
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
	 * request to create a new appointment
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appointment/new", method = RequestMethod.GET)
	public ModelAndView bookApointment(Model model) {
		logger.info("user requested to book an appointment");
		ModelAndView mv = new ModelAndView("bookappointment");
		List<String> doctorList = loginService.getAllDoctors();
		mv.addObject("doctorList", doctorList);
		mv.addObject("appointmentDTO", new AppointmentDTO());
		mv.addObject("name", getPrincipal());
		return mv;
	}

	/**
	 * Save the details of an appointment
	 * @param appointmentDTO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appointment/save", method = RequestMethod.POST)
	public String saveApointment(AppointmentDTO appointmentDTO, Model model) {
		logger.info("user requested to save an appointment");
		//
		Integer appointmentId = appointmentService
				.bookNewAppointment(appointmentDTO);

		// ModelAndView mv = new ModelAndView("viewappointmenet");
		// mv.addObject("appointmentDTO", savedAppointmentDTO);
		return "redirect:/appointment/" + appointmentId + "/view";
	}

	/**
	 * Get details of an appointment
	 * @param appointmentId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/appointment/{appointmentId}/view", method = RequestMethod.GET)
	public ModelAndView viewApointment(@PathVariable int appointmentId,
			Model model) {
		logger.info("user requested to save an appointment");
		//
		AppointmentDTO savedAppointmentDTO = appointmentService
				.getAppointment(appointmentId);
		ModelAndView mv = new ModelAndView("viewappointment");
		mv.addObject("appointmentDTO", savedAppointmentDTO);
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
	 * Web service to search for appointments based on a filter criteria
	 * @param model
	 * @param filterDTO
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/appointment/list", method = RequestMethod.POST)
	public @ResponseBody AppointmentListDTO getAllAppointments(
			@RequestBody AppointmentFilterDTO filterDTO,
			HttpServletRequest request) throws Exception {
		AppointmentListDTO appointlistDTO = new AppointmentListDTO();

		List<AppointmentDTO> appointmentList = appointmentService
				.searchAppointments(filterDTO);

		appointlistDTO.setAppointmentList(appointmentList);

		return appointlistDTO;
	}

}
