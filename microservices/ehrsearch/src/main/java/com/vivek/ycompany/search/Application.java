package com.vivek.ycompany.search;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.vivek.ycompany.search.entity.Doctor;
import com.vivek.ycompany.search.repository.DoctorRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... strings) throws Exception {
		List<Doctor> doctors = new ArrayList<>();
		doctors.add(new Doctor("Vivek Malhotra"));
		doctors.add(new Doctor("Pankaj Dewan"));
		doctors.add(new Doctor("Ankita Diwakar"));
		doctors.add(new Doctor("Varun Malhotra"));
		logger.info("save doctors to memory DB");
		doctorRepository.save(doctors);
	
	}
	 
}
