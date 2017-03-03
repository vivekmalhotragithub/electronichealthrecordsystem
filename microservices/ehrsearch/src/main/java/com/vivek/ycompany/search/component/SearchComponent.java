package com.vivek.ycompany.search.component;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

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
	private static final Logger logger = LoggerFactory
			.getLogger(SearchComponent.class);

	private AppointmentRepository appointmentRepository;

	private DoctorRepository doctorRepository;

	// private PatientRepository patientRepository;

	@Autowired
	public SearchComponent(DoctorRepository doctorRepository,
			AppointmentRepository appointmentRepository) {
		this.doctorRepository = doctorRepository;
		this.appointmentRepository = appointmentRepository;
		// this.patientRepository = patientRepository;
	}

	public List<Doctor> search(SearchQuery query) {
		logger.info("Searching for doctors with name=" + query.getDoctor());
		List<Doctor> flights = doctorRepository
				.findByFullNameLikeIgnoreCase(query.getDoctor() + "%");

		return flights;
	}
	
	
	@Transactional
	public void updateAppointment(Long appointmentId, Long doctorId,
			Long patientId, String patientName, String patientEmail,
			Date appointmentDate) {
		Doctor doctor = doctorRepository.getOne(doctorId);
		Appointment appointment = new Appointment(appointmentDate, doctor);
		appointment.setId(appointmentId);
		appointment.setPatientId(patientId);
		appointment.setPatientName(patientName);
		appointment.setPatientEmail(patientEmail);

		logger.info("Adding Appointment with details=" + appointment);
		appointmentRepository.save(appointment);
	}

	public List<Appointment> getAllAppointment() {
		logger.info("Fetching all Appointments");
		return appointmentRepository.findAll();
	}
}
