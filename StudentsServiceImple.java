package com.example.studentmanagementsystem.serviceimple;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.studentmanagementsystem.dto.Students;
import com.example.studentmanagementsystem.repository.StudentRepository;
import com.example.studentmanagementsystem.service.StudentService;

@Service
public class StudentsServiceImple implements StudentService{
	private StudentRepository repository;
	

	public StudentsServiceImple(StudentRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public List<Students> getAllStudents() {
		
		return repository.findAll();
	}


	@Override
	public Students saveStudent(Students students) {
		
		return repository.save(students);
	}


	@Override
	public Students getStudentById(int id) {
		
		return repository.findById(id).get();
	}


	@Override
	public Students upadteStudent(Students students) {
		
		return repository.save(students);
	}


	@Override
	public void deleteStudentById(int id) {
		
	     repository.deleteById(id);
		
	}

}
