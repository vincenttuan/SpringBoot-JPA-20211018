package com.example.demo.test.oneway_mto1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.oneway_mto1.Customer;
import com.example.demo.entity.oneway_mto1.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class Create {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void start() {
		System.out.println("Create");
		Customer c1 = new Customer();
		c1.setName("John");
		c1.setAge(20);
		
		Order o1 = new Order();
		o1.setName("A-1");
		Order o2 = new Order();
		o2.setName("B-2");
		
		// 設置關聯關係
		o1.setCustomer(c1);
		o2.setCustomer(c1);
		
		// 執行單向多對一的保存
		// 單向多對一進行儲存的時候
		// 必須先存「一」的一方再存「多」的一方
		customerRepository.save(c1); //「一」的一方
		orderRepository.save(o1); //「多」的一方
		orderRepository.save(o2); //「多」的一方
		
	}
}
