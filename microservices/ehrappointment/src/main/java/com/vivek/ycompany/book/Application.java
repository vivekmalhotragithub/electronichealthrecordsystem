package com.vivek.ycompany.book;

import java.util.Arrays;
import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.vivek.ycompany.book.component.AppointmentComponent;
import com.vivek.ycompany.book.entity.Appointment;
import com.vivek.ycompany.book.entity.Doctor;
import com.vivek.ycompany.book.entity.Patient;
import com.vivek.ycompany.book.repository.DoctorRepository;


@EnableDiscoveryClient
@SpringBootApplication
public class Application implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private AppointmentComponent bookingComponent;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Transactional
	@Override
	public void run(String... strings) throws Exception {
		
		Doctor[] invs = { 
					new Doctor("Vivek Malhotra"),
					new Doctor("Varun Malhotra"),
					new Doctor("Pankaj Dewan"),
					new Doctor("Ankita Diwakar"),
		};
		Arrays.asList(invs).forEach(doctor -> doctorRepository.save(doctor));
				
		Doctor doctor = doctorRepository.findOne(1L);
		
		Appointment booking = new Appointment(new Date(), new Patient("Anjali Mehrotra", "anjali.mehrotra@gmail.com"), doctor);
		
 		long record  = bookingComponent.book(booking);
		logger.info("Appointment successfully saved..." + record);
		
	    
	}
	
}
