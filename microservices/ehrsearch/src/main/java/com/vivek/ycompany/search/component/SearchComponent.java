package com.vivek.ycompany.search.component;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vivek.ycompany.search.controller.SearchQuery;
import com.vivek.ycompany.search.entity.Appointment;
import com.vivek.ycompany.search.entity.Doctor;
import com.vivek.ycompany.search.repository.AppointmentRepository;
import com.vivek.ycompany.search.repository.DoctorRepository;

@Component
public class SearchComponent {
	private static final Logger logger = LoggerFactory.getLogger(SearchComponent.class);
	
	private AppointmentRepository appointmentRepository;
	
	private DoctorRepository doctorRepository;
	
	@Autowired
	public SearchComponent(DoctorRepository flightRepository){
		this.doctorRepository = flightRepository;
	}

	public List<Doctor> search(SearchQuery query){
		logger.info("Searching for doctors with name=" + query.getDoctor());
		List<Doctor> flights= doctorRepository.findByFullNameLikeIgnoreCase(query.getDoctor()+"%"); 
		
		return flights; 
	}

	public void updateAppointment(Appointment appointment) {
		logger.info("Adding Appointment with details="+appointment);
		appointmentRepository.save(appointment);
	}
	
	public List<Appointment> getAllAppointment() {
		logger.info("Fetching all Appointments");
		return appointmentRepository.findAll();
	}
}
