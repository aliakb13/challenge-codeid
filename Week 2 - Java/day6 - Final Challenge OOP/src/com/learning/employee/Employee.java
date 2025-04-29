package com.learning.employee;

import com.learning.enums.Status;

import java.time.LocalDate;
import java.util.Random;

abstract public class Employee {
    private final int empId;
    private final String fullName;
    private final LocalDate hireDate;
    private final Status status;
    private final double salary;
    private double totalSalary;
    public static int totalEmployee;
    public static double sumOfSalary = 0;

    public Employee(String fullName, LocalDate hireDate, Status status, double salary) {
        Random random = new Random();
        this.empId = random.nextInt(100,120);
        this.fullName = fullName;
        this.hireDate = hireDate;
        this.status = status;
        this.salary = salary;
        totalEmployee++;
        sumOfSalary += salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Status getStatus() {
        return status;
    }

    public double getSalary() {
        return salary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
