package com.raj.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raj.springdatajpa.entities.Student;
import com.raj.springdatajpa.repos.StudentRepository;

import static org.junit.Assert.*;

@SpringBootTest
class Springdatajpa2ApplicationTests {
	
	@Autowired
	private StudentRepository repository;

	@Test
	void testSaveStudent() {
		Student student = new Student();		
		student.setId(1L);
		student.setName("Raj");
		student.setTestScore(99);		
		repository.save(student);
		
		Student savedStudent = repository.findById(1L).get();
		assertNotNull(savedStudent);
		System.out.println(savedStudent);
	}

}
