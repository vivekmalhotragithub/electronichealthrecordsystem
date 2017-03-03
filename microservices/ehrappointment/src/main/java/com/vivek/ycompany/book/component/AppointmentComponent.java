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
import com.vivek.ycompany.book.entity.Doctor;
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

	DoctorRepository doctorRepository;

	PatientRepository patientRepository;

	Sender sender;

	@Autowired
	public AppointmentComponent(AppointmentRepository bookingRepository,
			Sender sender, DoctorRepository doctorRepository,
			PatientRepository patientRepository) {
		this.appointmentRepository = bookingRepository;
		this.sender = sender;
		this.doctorRepository = doctorRepository;
		this.patientRepository = patientRepository;
	}

	@Transactional
	public long book(Appointment record) {
		logger.info("Validating Appointment record " + record);
		List<Patient> patients = patientRepository.findByEmail(record
				.getPatient().getEmail());
		Doctor doctor = doctorRepository.findOne(record.getDoctor().getId());
		if (patients != null && !patients.isEmpty()) {
			record.setPatient(patients.get(0));
		}

		if (doctor != null) {
			record.setDoctor(doctor);
		} else {
			throw new BookingException("Doctor with id="
					+ record.getDoctor().getId() + " Not found!");
		}
		long id = appointmentRepository.save(record).getId();
		logger.info("Successfully saved Appointment");
		// send a message to search to update Appointments
		record.setId(id);
		logger.info("sending a Appointment event");
//		Map<String, Object> appointmentDetails = new HashMap<String, Object>();
//		appointmentDetails.put("DOCTOR_ID", record.getDoctor().getId());
//		appointmentDetails.put("DOCTOR_NAME", record.getDoctor().getId());
//		appointmentDetails.put("PATIENT_ID", record.getPatient().getId());
//		appointmentDetails.put("PATIENT_NAME", record.getPatient()
//				.getFullName());
//		appointmentDetails.put("PATIENT_EMAIL", record.getPatient().getEmail());
//		appointmentDetails.put("APPOINTMENT_DATE", record.getDate());
		sender.send(record);
		logger.info("Appointment event successfully delivered "
				+ record);
		return id;
	}

	public Appointment getAppointment(long id) {
		return appointmentRepository.findOne(id);
	}

}
