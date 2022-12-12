package com.example.search.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private String status;
    private EmployeeData[] data;

}
