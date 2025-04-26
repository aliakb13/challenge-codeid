package com.learning.classes.employee;

import com.learning.Role;

import java.util.Random;

abstract public class Employee {
    private int empId;
    private String fullName;
    private Role role;
    private double salary;
    private double totalSalary;

    public Employee(String fullName, Role role, double salary) {
        Random random = new Random();
        this.empId = random.nextInt(100, 120);
        this.fullName = fullName;
        this.role = role;
        this.salary = salary;
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

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public double calcTax() {
        return this.getTotalSalary() * 0.5;
    }

    public abstract void calculateSalary();

}
