package com.vivek.ycompany.search.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.ycompany.search.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	List<Doctor> findByFullName(String fullName);
} 