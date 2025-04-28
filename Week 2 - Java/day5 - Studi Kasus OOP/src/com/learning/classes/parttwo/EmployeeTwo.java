package com.learning.classes.parttwo;

import com.learning.Role;

import java.util.Random;

abstract public class EmployeeTwo {

    private final int empId;
    private final String fullName;
    private final Role role;
    private final double salary;
    private double totalSalary;

    public EmployeeTwo(String fullName, Role role, double salary) {
        Random random = new Random();
        this.empId = random.nextInt(100,120);
        this.fullName = fullName;
        this.role = role;
        this.salary = salary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getFullName() {
        return fullName;
    }

    public Role getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}
