package com.example.demo.test.twoway_mtom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.twoway_mtom.Course;
import com.example.demo.twoway_mtom.Student;

@SpringBootTest
public class Create {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	public void start() {
		System.out.println("Create");
		Course c1 = new Course();
		c1.setName("Java");
		Course c2 = new Course();
		c2.setName("Python");
		
		Student s1 = new Student();
		s1.setName("John");
		Student s2 = new Student();
		s2.setName("Mary");
		
		// 設置關聯關係
		c1.getStudents().add(s1);
		c2.getStudents().add(s2);
		s1.getCourses().add(c1);
		s2.getCourses().add(c2);
		
		// 執行保存
		// 要先保存 student (有設定 mappedBy)，因為 course 會自己自動維護關聯關係
		studentRepository.save(s1);
		studentRepository.save(s2);
		courseRepository.save(c1);
		courseRepository.save(c2);
		
		// Homework 執行聯集保存 ?
	}
}
