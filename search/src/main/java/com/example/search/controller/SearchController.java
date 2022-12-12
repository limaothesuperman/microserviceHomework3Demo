package com.example.search.controller;

import com.example.search.domain.Employee;
import com.example.search.domain.EmployeeData;
import com.example.search.domain.dto.StudentDto;
import com.example.search.domain.dto.TeacherDto;
import com.example.search.service.EmployeeService;
import com.example.search.service.UniversityService;
import com.example.search.service.UniversityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final EmployeeService employeeService;
    private final UniversityService universityService;

    public SearchController(EmployeeService employeeService, UniversityService universityService) {
        this.employeeService = employeeService;
        this.universityService = universityService;
    }

    @GetMapping("/search/employees")
    public ResponseEntity<?> getDetails(@RequestParam List<Integer> ages) {
        //TODO
        return new ResponseEntity<>(employeeService.fetchAllEmployeesByAges(ages), HttpStatus.OK);
    }

    @GetMapping("/search/university/employees")
    public ResponseEntity<EmployeeData[]> getAllEmployees() {
        return new ResponseEntity<>(universityService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/search/university/students")
    public ResponseEntity<ResponseEntity<StudentDto>> getAllStudents() {
        return new ResponseEntity<>(universityService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/search/university/teachers")
    public ResponseEntity<ResponseEntity<TeacherDto>> getAllTeachers() {
        return new ResponseEntity<>(universityService.getAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/search/university/employeeandstudent")
    public void getEmployeeAndStudent() {
        Multithreading1 m1 = new Multithreading1(universityService);
        Multithreading2 m2 = new Multithreading2(universityService);
        m1.run();
        m2.run();
    }
}

class Multithreading1 implements Runnable {
    private final UniversityService universityService;

    Multithreading1(UniversityService universityService) {
        this.universityService = universityService;
    }

    public void run() {
        try {
            universityService.getAllEmployees();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

class Multithreading2 implements Runnable {
    private final UniversityService universityService;

    Multithreading2(UniversityService universityService) {
        this.universityService = universityService;
    }

    public void run() {
        try {
            universityService.getAllStudents();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
