package com.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.studentmanagementsystem.entities.Student;
import com.studentmanagementsystem.service.StudentServices;

@Controller
public class StudentController {
	@Autowired
	private StudentServices services;

	public StudentController(StudentServices services) {
		super();
		this.services = services;
	}
	@GetMapping("/students")
	public String  listStudent(Model model) {	
		model.addAttribute("students",services.getAllStudent());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student Form Data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		services.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("student", services.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student,Model model) {
		
		//get Student From Database by id
		Student existingStudent = services.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setFirst_name(student.getFirst_name());
		existingStudent.setLast_name(student.getLast_name());
		existingStudent.setEmail(student.getEmail());
		
		//save updated Student object
		services.editStudentForm(existingStudent);
		return "redirect:/students";	
	}	
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		services.deleteStudentById(id);
		return "redirect:/students";
		
	}
	
	
}
