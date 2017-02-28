package com.vivek.ycompany.book.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.ycompany.book.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

	List<Patient> findByEmail(String email);
	
}
