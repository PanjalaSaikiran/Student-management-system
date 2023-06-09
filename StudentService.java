package com.example.studentmanagementsystem.service;

import java.util.List;

import com.example.studentmanagementsystem.dto.Students;

public interface StudentService {
	
	List<Students> getAllStudents();
	
	Students saveStudent(Students students);
	
	Students getStudentById(int id);
	
	Students upadteStudent(Students students);
	
	void deleteStudentById(int id);

}
