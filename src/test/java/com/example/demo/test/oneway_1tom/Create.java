package com.example.demo.test.oneway_1tom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.oneway_1tom.Infect;
import com.example.demo.oneway_1tom.Vaccine;
import com.example.demo.repository.InfectRepository;
import com.example.demo.repository.VaccineRepository;

@SpringBootTest
public class Create {
	@Autowired
	InfectRepository infectRepository;
	
	@Autowired
	VaccineRepository vaccineRepository;
	
	@Test
	public void begin() {
		System.out.println("Create");
		
		Infect infect = new Infect();
		infect.setName("COVID-19");
		
		Vaccine v1 = new Vaccine();
		v1.setName("AZ");
		v1.setCount(2);
		Vaccine v2 = new Vaccine();
		v2.setName("BNT");
		v2.setCount(2);
		Vaccine v3 = new Vaccine();
		v3.setName("PJ"); // 嬌生(JP)
		
		// 設置關聯關係
		infect.getVaccines().add(v1);
		infect.getVaccines().add(v2);
		infect.getVaccines().add(v3);
		
		// 執行保存
		// 單向一對多，因為是由「一」方來維護「多」方的關聯欄位，所以他會增加 update 語句
		//vaccineRepository.save(v1);
		//vaccineRepository.save(v2);
		//vaccineRepository.save(v3);
		//infectRepository.save(infect);
		
		// 執行保存 - 聯集保存
		// 單向一對多的聯集保存 @OneToMany(cascade = CascadeType.PERSIST) 
		infectRepository.save(infect); 
		
	}
}
