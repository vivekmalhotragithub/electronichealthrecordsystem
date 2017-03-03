package com.vivek.ycompany.client;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.vivek.ycompany.client.dto.Doctor;

@EnableFeignClients
@EnableDiscoveryClient
@EnableGlobalMethodSecurity
@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
   	SearchServiceProxy searchServiceProxy;
	
//  	RestTemplate bookingClient = new RestTemplate();
//	
//   	RestTemplate checkInClient = new RestTemplate();
//	
//	 RestTemplate restClient= new RestTemplate();
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	 
	@Override
	public void run(String... strings) throws Exception {
		//Search for Doctors
		SearchQuery searchQuery = new SearchQuery("Varun Malhotra");
 		
		List<Doctor> doctors = searchServiceProxy.getDoctors(searchQuery); 
 		
		Arrays.asList(doctors).forEach(flight -> logger.info(" doctors >"+ doctors));
  		
		//create an appointment only if there are doctors.
 		if(doctors == null || doctors.size() == 0){
 			return;
 		}

		
	}
		 
}