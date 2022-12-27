package com.studentmanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentmanagementsystem.entities.Student;
import com.studentmanagementsystem.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystem2Application  {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystem2Application.class, args);
	}
}
