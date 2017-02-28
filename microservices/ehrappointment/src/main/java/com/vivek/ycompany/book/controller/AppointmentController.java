package com.vivek.ycompany.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.ycompany.book.component.AppointmentComponent;
import com.vivek.ycompany.book.entity.Appointment;

@RestController
@CrossOrigin
@RequestMapping("/booking")
public class AppointmentController {
	
	AppointmentComponent appointmentComponent;
	
	@Autowired
	AppointmentController(AppointmentComponent bookingComponent){
		this.appointmentComponent = bookingComponent;
	}

	@RequestMapping(value="/create" , method = RequestMethod.POST)
	long book(@RequestBody Appointment appointment){
		System.out.println("Appointment Request" + appointment); 
		return appointmentComponent.book(appointment);
	}
	
	@RequestMapping("/get/{id}")
	Appointment getBooking(@PathVariable long id){
		return appointmentComponent.getAppointment(id);
	}	
}
