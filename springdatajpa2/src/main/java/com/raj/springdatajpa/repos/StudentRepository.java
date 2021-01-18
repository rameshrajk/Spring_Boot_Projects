package com.raj.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
