package com.vivek.ycompany.search.component;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vivek.ycompany.search.controller.SearchQuery;
import com.vivek.ycompany.search.entity.Doctor;
import com.vivek.ycompany.search.repository.DoctorRepository;

@Component
public class SearchComponent {
	private DoctorRepository doctorRepository;
	private static final Logger logger = LoggerFactory.getLogger(SearchComponent.class);
	
	
	@Autowired
	public SearchComponent(DoctorRepository flightRepository){
		this.doctorRepository = flightRepository;
	}

	public List<Doctor> search(SearchQuery query){
		logger.info("Searching for doctors with name=" + query.getDoctor());
		List<Doctor> flights= doctorRepository.findByFullNameLikeIgnoreCase(query.getDoctor()+"%"); 
		
		return flights; 
	}

//	public void updateInventory(String flightNumber, String flightDate, int inventory) {
//		logger.info("Updating inventory for flight "+ flightNumber + " innventory "+ inventory); 
//		Appointment flight = doctorRepository.findByFlightNumberAndFlightDate(flightNumber,flightDate);
//		Doctor inv = flight.getInventory();
//		inv.setCount(inventory);
//		doctorRepository.save(flight); 
//	} 
}
