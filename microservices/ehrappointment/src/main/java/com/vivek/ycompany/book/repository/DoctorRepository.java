package com.vivek.ycompany.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.ycompany.book.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	
	
}
