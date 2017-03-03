package com.vivek.ycompany.search.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.ycompany.search.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	List<Appointment> findByFullNameLikeIgnoreCase(String fullName);
} 