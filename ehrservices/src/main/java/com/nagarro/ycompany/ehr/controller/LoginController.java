/**
 * 
 */
package com.nagarro.ycompany.ehr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.ycompany.ehr.service.impl.LoginServiceImpl;

/**
 * @author vivekmalhotra
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	@Qualifier(value = "loginService")
	private LoginServiceImpl loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		return new ModelAndView("login");
	}
	
//	@RequestMapping(value = "/login?error", method = RequestMethod.GET)
//	public ModelAndView loginProcess(@ModelAttribute("loginObjectDTO")UserCredentialDTO loginObjectDTO) {
//		ModelAndView modelView =  new ModelAndView("login");
//		modelView.addObject("errormessage", "Username or password do not match");
//		return modelView;
//	}
	
	
	// get the current user from Security context
	 private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }

}
