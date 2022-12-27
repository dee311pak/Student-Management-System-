package com.studentmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagementsystem.entities.Student;
import com.studentmanagementsystem.repository.StudentRepository;

@Service
public class Student_Services_Impl implements StudentServices {

	@Autowired
	private StudentRepository repository;

	public Student_Services_Impl(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Student> getAllStudent() {

		return repository.findAll();

	}

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		
		return repository.findById(id).get();
	}

	@Override
	public Student editStudentForm(Student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
}
