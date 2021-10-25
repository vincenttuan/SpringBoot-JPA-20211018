package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.twoway_mtom.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
