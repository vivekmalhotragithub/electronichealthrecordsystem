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

import com.vivek.ycompany.book.dto.AppointmentDTO;
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
	public long book(AppointmentDTO record) {
		logger.info("Validating Appointment record " + record);

		Doctor doctor = doctorRepository.findOne(record.getDoctor().getId());
		Appointment appointment = new Appointment();
		if (doctor != null) {
			appointment.setDoctor(doctor);
		} else {
			throw new BookingException("Doctor with id="
					+ appointment.getDoctor().getId() + " Not found!");
		}
		List<Patient> patients = patientRepository.findByEmail(record
				.getPatientEmail());
		if (patients != null && !patients.isEmpty()) {
			appointment.setPatient(patients.get(0));
		} else {
			appointment.setPatient(new Patient(record.getPatientName(), record
					.getPatientEmail(), record.getPatientGender()));
		}

		long id = appointmentRepository.save(appointment).getId();
		logger.info("Successfully saved Appointment");
		// send a message to search to update Appointments
		appointment.setId(id);
		List<Patient> savedPatients = patientRepository.findByEmail(record
				.getPatientEmail());
		logger.info("sending a Appointment event");
		Map<String, Object> appointmentDetails = new HashMap<String, Object>();
		appointmentDetails.put("APPOINTMENT_ID", appointment.getId());
		appointmentDetails.put("DOCTOR_ID", appointment.getDoctor().getId());
		appointmentDetails.put("PATIENT_ID", savedPatients.get(0).getId());
		appointmentDetails.put("PATIENT_NAME", appointment.getPatient()
				.getFullName());
		appointmentDetails.put("PATIENT_EMAIL", appointment.getPatient()
				.getEmail());
		appointmentDetails.put("APPOINTMENT_DATE", appointment.getDate());
		sender.send(appointmentDetails);
		logger.info("Appointment event successfully delivered "
				+ appointmentDetails);
		return id;
	}

	public Appointment getAppointment(long id) {
		return appointmentRepository.findOne(id);
	}

}
