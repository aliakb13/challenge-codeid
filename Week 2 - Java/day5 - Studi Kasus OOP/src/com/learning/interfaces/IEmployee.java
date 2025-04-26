package com.learning.interfaces;

import com.learning.classes.employee.Employee;

import java.util.List;

public interface IEmployee {

    List<Employee> initListEmployee();
    void printEmployee(List<Employee> listOfEmp);
    void generateTaxAndSalary(List<Employee> listOfEmp);
}
