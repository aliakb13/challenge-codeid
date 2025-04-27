package com.learning.interfaces;

import com.learning.classes.partone.employee.Employee;

import java.util.List;

public interface IEmployee {

    List<Employee> initListEmployee();
    void printEmployee(List<Employee> listOfEmp);
    void generateTaxAndSalary(List<Employee> listOfEmp);

//    this method supposed for partTwo
    List<ISalary> initEmployeeTwo();
    void printEmployeeTwo(List<ISalary> listOfEmp);
    void generateTaxAndSalaryTwo(List<ISalary> listOfEmp);
}
