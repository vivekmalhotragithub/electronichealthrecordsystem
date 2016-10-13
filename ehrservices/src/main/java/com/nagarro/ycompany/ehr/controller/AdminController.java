/**
 * 
 */
package com.nagarro.ycompany.ehr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author vivekmalhotra
 *
 */
@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome(Model model) {
		logger.info("Welcome to admin page");
		ModelAndView mv = new ModelAndView("dashboard");
		mv.addObject("name", getPrincipal());
		return mv;
	}
	
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
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
