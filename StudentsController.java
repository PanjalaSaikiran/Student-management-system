package com.example.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.studentmanagementsystem.dto.Students;
import com.example.studentmanagementsystem.service.StudentService;

@Controller
public class StudentsController {
	private StudentService service;

	public StudentsController(StudentService service) {
		super();
		this.service = service;
	}
//	@GetMapping("/hello")
//	public String hii() {
//		return "home";
//	}
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return "students";
	}
	@GetMapping("/students/new")
	public String creatStudent(Model model) {
		Students students=new Students();
		model.addAttribute("students", students);
		return "create_student";
	}
	@PostMapping("/students")
    public String saveStudent(@ModelAttribute("students")Students students) {
    	service.saveStudent(students);
    	return "redirect:/students";
    }
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable int id,Model model) {
		model.addAttribute("student", service.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student") Students students,Model model) {
		Students existingStudent=service.getStudentById(id);
		existingStudent.setFirstName(students.getFirstName());
		existingStudent.setLastName(students.getLastName());
		existingStudent.setEmail(students.getEmail());
		service.upadteStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudentById(@PathVariable int id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}
}
