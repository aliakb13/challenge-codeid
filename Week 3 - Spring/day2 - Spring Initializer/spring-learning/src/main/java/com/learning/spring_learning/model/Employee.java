package com.learning.spring_learning.model;

import java.time.LocalDate;
import java.util.Random;

public class Employee {
  private int empId;
  private String fullname;
  private LocalDate hireDate;
  private double salary;

  public Employee(String fullname, LocalDate hireDate, double salary) {
    Random random = new Random();
    this.empId = random.nextInt(100,120);
    this.fullname = fullname;
    this.hireDate = hireDate;
    this.salary = salary;
  }

  public int getEmpId() {
    return empId;
  }

  public String getFullname() {
    return fullname;
  }

  public LocalDate getHireDate() {
    return hireDate;
  }

  public double getSalary() {
    return salary;
  }
}
