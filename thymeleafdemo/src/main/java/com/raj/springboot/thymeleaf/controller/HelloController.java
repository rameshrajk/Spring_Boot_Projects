package com.raj.springboot.thymeleaf.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.raj.springboot.thymeleaf.model.Student;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Treat yoself");
		return mav;
	}
	
	@RequestMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student student = new Student();
		student.setName("Billy Bob");
		student.setScore(94);
		mav.addObject("student", student);
		return mav;
	}
	
	@RequestMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView mav = new ModelAndView("studentList");
		
		Student student = new Student();
		student.setName("Ratchet");
		student.setScore(81);
		
		Student student2 = new Student();
		student2.setName("Clank");
		student2.setScore(99);
		
		List<Student> students = Arrays.asList(student, student2);
		
		mav.addObject("students", students);
		return mav;
	}
	
	@RequestMapping("/studentForm")
	public ModelAndView displayStudentForm() {
		ModelAndView mav = new ModelAndView("studentForm");
		Student student = new Student();
		student.setName("Ratchet");
		student.setScore(81);
		mav.addObject("student", student);
		return mav;
	}
	
	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(student.getName());
		System.out.println(student.getScore());
		return mav;
	}
}
