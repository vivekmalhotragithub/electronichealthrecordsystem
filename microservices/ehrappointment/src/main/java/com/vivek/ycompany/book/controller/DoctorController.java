package com.vivek.ycompany.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.ycompany.book.entity.Doctor;
import com.vivek.ycompany.book.repository.DoctorRepository;

@RestController
@CrossOrigin
@RequestMapping("/doctor")
public class DoctorController {
	
	DoctorRepository doctorRepository;
	
	@Autowired
	DoctorController(DoctorRepository doctorRepository){
		this.doctorRepository = doctorRepository;
	}

	@RequestMapping("/{doctorId}/get")
	Doctor getBooking(@PathVariable("doctorId") long doctorId){
		return doctorRepository.findOne(doctorId);
	}	
}
