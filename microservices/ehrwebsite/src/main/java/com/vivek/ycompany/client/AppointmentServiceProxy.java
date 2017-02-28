package com.vivek.ycompany.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vivek.ycompany.client.dto.Appointment;
import com.vivek.ycompany.client.dto.Doctor;

@FeignClient(value ="booking-service")
public interface AppointmentServiceProxy {

	
	@RequestMapping(value = "doctor/{doctorId}/get", method = RequestMethod.GET)
	Doctor getDoctors(@PathVariable(name="doctorId") Long doctorId);
	
	@RequestMapping(value = "booking/create", method = RequestMethod.POST)
	Long book(@RequestBody Appointment appointment);
}
