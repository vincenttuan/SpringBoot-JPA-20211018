package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.oneway_1tom.Infect;

@Repository
public interface InfectRepository extends JpaRepository<Infect, Long> {
	
}
