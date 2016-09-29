package com.nagarro.ycompany.ehr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.ycompany.ehr.service.impl.InternalUserServiceImpl;

@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";

	@Autowired(required=true)
	@Qualifier(value="internalUserService")
	private InternalUserServiceImpl internalUserService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
		String userList = internalUserService.getAllUsers();
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		mv.addObject("allusers", userList);
		return mv;
	}
}
