package com.example.demo.test.twoway_1tom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.MenuGroupRepository;
import com.example.demo.repository.MenuItemRepository;
import com.example.demo.twoway_1tom.MenuGroup;
import com.example.demo.twoway_1tom.MenuItem;

@SpringBootTest
public class Create {
	@Autowired
	MenuGroupRepository menuGroupRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Test
	public void start() {
		System.out.println("Create");
		MenuGroup mg = new MenuGroup();
		mg.setName("Food");
		
		MenuItem m1 = new MenuItem();
		m1.setName("A");
		m1.setPrice(100);
		MenuItem m2 = new MenuItem();
		m2.setName("B");
		m2.setPrice(50);
		
		// 設置關聯關係
		mg.getItems().add(m1);
		mg.getItems().add(m2);
		m1.setMenuGroup(mg);
		m2.setMenuGroup(mg);
		
		// 執行保存
		//menuGroupRepository.save(mg);
		//menuItemRepository.save(m1);
		//menuItemRepository.save(m2);
		
		// 執行保存(聯集)
		// MenuGroup 中加上 cascade = CascadeType.PERSIST
		menuGroupRepository.save(mg);
	}
}
