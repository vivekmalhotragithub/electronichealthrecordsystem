/**
 * 
 */
package com.nagarro.ycompany.ehr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author vivekmalhotra
 *
 */
@Controller
public class LoginController {

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}

}
