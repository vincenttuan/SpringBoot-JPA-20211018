package com.example.demo.test.oneway_mto1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.oneway_mto1.Customer;
import com.example.demo.entity.oneway_mto1.Order;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@SpringBootTest
public class Update {
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void start() {
		// 假設我想要修改id=1的訂單名稱與其客戶年齡
		Order order = orderRepository.findById(1L).get();
		Customer customer = order.getCustomer();
		order.setName("A-1");
		customer.setAge(20);
		// 進行資料保存
		//orderRepository.save(order);
		//customerRepository.save(customer);
		// 進行資料保存 - 聯集保存
		// 在 @ManyToOne 中 加入 cascade = CascadeType.MERGE
		orderRepository.save(order);
		//customerRepository.save(customer); // 可以不用寫，而由系統自動產生
	}
}
