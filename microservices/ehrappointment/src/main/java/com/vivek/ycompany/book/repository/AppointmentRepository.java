package com.vivek.ycompany.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.ycompany.book.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
}
