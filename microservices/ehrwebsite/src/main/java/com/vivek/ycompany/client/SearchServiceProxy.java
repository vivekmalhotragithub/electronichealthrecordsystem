package com.vivek.ycompany.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vivek.ycompany.client.dto.Appointment;
import com.vivek.ycompany.client.dto.Doctor;

@FeignClient(value ="search-service")
public interface SearchServiceProxy {

	
	@RequestMapping(value = "search/get", method = RequestMethod.POST)
	List<Doctor> getDoctors(@RequestBody SearchQuery searchQuery);
	
	@RequestMapping(value = "search/appointments", method = RequestMethod.GET)
	List<Appointment> getAppointments();
}
