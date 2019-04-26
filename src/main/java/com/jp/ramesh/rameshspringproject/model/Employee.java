package com.jp.ramesh.rameshspringproject.model;

import lombok.Data;

@Data
public class Employee {

    private int empid;
    private String name;
    private String department;
    private String designation;

    public Employee(int empid, String name, String department, String designation) {
        this.empid = empid;
        this.name = name;
        this.department = department;
        this.designation = designation;
    }
}

