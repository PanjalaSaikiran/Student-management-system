package com.example.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagementsystem.dto.Students;

public interface StudentRepository extends JpaRepository<Students, Integer>{

}
