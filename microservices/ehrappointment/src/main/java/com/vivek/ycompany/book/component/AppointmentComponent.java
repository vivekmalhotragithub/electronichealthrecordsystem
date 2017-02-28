package com.vivek.ycompany.book.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;

import com.vivek.ycompany.book.entity.Appointment;
import com.vivek.ycompany.book.entity.Patient;
import com.vivek.ycompany.book.repository.AppointmentRepository;
import com.vivek.ycompany.book.repository.DoctorRepository;
import com.vivek.ycompany.book.repository.PatientRepository;

@EnableFeignClients
@Component
public class AppointmentComponent {
	private static final Logger logger = LoggerFactory
			.getLogger(AppointmentComponent.class);
	
	AppointmentRepository appointmentRepository;

	DoctorRepository inventoryRepository;

	PatientRepository patientRepository;

	Sender sender;

	@Autowired
	public AppointmentComponent(AppointmentRepository bookingRepository,
			Sender sender, DoctorRepository inventoryRepository,
			PatientRepository patientRepository) {
		this.appointmentRepository = bookingRepository;
		this.sender = sender;
		this.inventoryRepository = inventoryRepository;
		this.patientRepository = patientRepository;
	}

	@Transactional
	public long book(Appointment record) {
		logger.info("calling fares to get fare");
		List<Patient> patients = patientRepository.findByEmail(record.getPatient().getEmail());
		if(patients != null && !patients.isEmpty()){
			record.setPatient(patients.get(0));
		}
		long id = appointmentRepository.save(record).getId();
		logger.info("Successfully saved Appointment");
		// send a message to search to update Appointments
		logger.info("sending a Appointment event");
		Map<String, Object> appointmentDetails = new HashMap<String, Object>();
		appointmentDetails.put("DOCTOR_ID", record.getDoctor().getId());
		appointmentDetails.put("PATIENT_ID", record.getPatient().getId());
		appointmentDetails.put("PATIENT_NAME", record.getPatient().getFullName());
		appointmentDetails.put("PATIENT_EMAIL", record.getPatient().getEmail());
		appointmentDetails.put("APPOINTMENT_DATE", record.getDate());
		sender.send(appointmentDetails);
		logger.info("Appointment event successfully delivered "
				+ appointmentDetails);
		return id;
	}

	public Appointment getAppointment(long id) {
		return appointmentRepository.findOne(id);
	}

}
