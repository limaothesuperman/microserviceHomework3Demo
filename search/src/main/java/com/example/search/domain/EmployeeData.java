package com.example.search.domain;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeData {
    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;

}
