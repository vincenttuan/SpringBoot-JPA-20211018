package com.example.demo.oneway_1tom;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// 傳染
@Entity
@Table(name = "infects")
public class Infect {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = true)
	private String name;
	
	// 單向ㄧ對多
	@OneToMany
	@JoinColumn(name = "infect_id")
	private Set<Vaccine> vaccines = new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(Set<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}
	
	
	
}
