package com.example.search.service;

import com.example.search.domain.Employee;
import com.example.search.domain.EmployeeData;
import com.example.search.domain.dto.StudentDto;
import com.example.search.domain.dto.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class UniversityServiceImpl implements UniversityService {

    private final RestTemplate ribbonRestTemplate;

    @Autowired
    public UniversityServiceImpl(RestTemplate ribbonRestTemplate) {
        this.ribbonRestTemplate = ribbonRestTemplate;
    }


    @Override
    public EmployeeData[] getAllEmployees() {

        return Objects.requireNonNull(ribbonRestTemplate
                .getForObject("http://university-service/employee", Employee.class)).getData();
    }

    @Override
    public ResponseEntity<StudentDto> getAllStudents() {
        return Objects.requireNonNull(ribbonRestTemplate
                .getForEntity("http://university-service/student", StudentDto.class));
    }

    @Override
    public ResponseEntity<TeacherDto> getAllTeachers() {
        return Objects.requireNonNull(ribbonRestTemplate
                .getForEntity("http://university-service/teacher", TeacherDto.class));
    }


}

