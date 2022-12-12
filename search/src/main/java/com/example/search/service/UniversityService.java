package com.example.search.service;

import com.example.search.domain.EmployeeData;
import com.example.search.domain.dto.StudentDto;
import com.example.search.domain.dto.TeacherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UniversityService {

    EmployeeData[] getAllEmployees();
    ResponseEntity<StudentDto> getAllStudents();
    ResponseEntity<TeacherDto> getAllTeachers();

}
