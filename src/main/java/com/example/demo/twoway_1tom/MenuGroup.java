package com.example.demo.twoway_1tom;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu_groups")
public class MenuGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = true)
	private String name;
	
	// 雙向一對多
	// @JoinColumn(name = "group_id") 移除此行
	// 使用 mappedBy 來放棄關聯維護，也不再使用 @JoinColumn
	// @OneToMany(mappedBy = "menuGroup")
	@OneToMany(mappedBy = "menuGroup", cascade = CascadeType.PERSIST)
	private Set<MenuItem> items = new LinkedHashSet<>();

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

	public Set<MenuItem> getItems() {
		return items;
	}

	public void setItems(Set<MenuItem> items) {
		this.items = items;
	}
	
	
}
