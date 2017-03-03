package com.vivek.ycompany.search.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.ycompany.search.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
} 