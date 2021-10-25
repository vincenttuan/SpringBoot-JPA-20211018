package com.example.demo.test.oneway_mto1;

import javax.persistence.FetchType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.oneway_mto1.Customer;
import com.example.demo.entity.oneway_mto1.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class Query {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void start() {
		// @ManyToOne 預設是 fetch = FetchType.EAGER
		// 所以 SQL 會進行 left outer join 來聯集其他資料表
		
		// @ManyToOne 手動改成 fetch = FetchType.LAZY
		// 就不會進行聯集查詢
		// 後來的程式若有調用到一的一方的資料時會自動生成 SQL 指令查詢，以滿足需求
		Order order = orderRepository.findById(1L).get();
		System.out.println(order.getName());
		
		System.out.println(order.getCustomer().getName());
		
	}
}
