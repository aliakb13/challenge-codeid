package com.learning;

import com.learning.classes.partone.employee.Employee;
import com.learning.classes.partone.employee.Programmer;
import com.learning.classes.partone.employee.QA;
import com.learning.classes.partone.employee.Sales;
import com.learning.classes.partone.salary.Commission;
import com.learning.classes.partone.salary.Overtime;
import com.learning.classes.partone.salary.Transport;
import com.learning.classes.parttwo.EmployeeTwo;
import com.learning.interfaces.IEmployee;
import com.learning.interfaces.ISalary;

import java.time.LocalDate;
import java.util.List;

public class EmployeeImpl implements IEmployee {

    @Override
    public List<Employee> initListEmployee() {
        Programmer prog1 = new Programmer("Udin Baharudin", 5_000_000,
                new Transport(LocalDate.now(),200_000,300_000,150_000),
                new Overtime(LocalDate.now(),80_000));

        Programmer prog2 = new Programmer("Ujang Surajang", 12_000_000,
                new Transport(LocalDate.now(),250_000,350_000,200_000),
                new Overtime(LocalDate.now(),110_000));

        Sales sales1 = new Sales("Siti Raharjo", 5_500_000,
                new Commission(LocalDate.now(),500_000,300_000),
                new Overtime(LocalDate.now(),120_000));

        QA qa1 = new QA("Rudi Sutarno", 7_500_000,
                new Overtime(LocalDate.now(),80_000));


        return List.of(prog1, prog2, sales1, qa1);
    }

    @Override
    public void printEmployee(List<Employee> listOfEmp) {
        for (Employee emp : listOfEmp) {
            System.out.println(emp);
        }
    }

    @Override
    public void generateTaxAndSalary(List<Employee> listOfEmp) {
        for (Employee emp : listOfEmp) {
            emp.calculateSalary();
            emp.calcTax();
        }
    }

    @Override
    public List<ISalary> initEmployeeTwo() {

        com.learning.classes.parttwo.Programmer prog1 = new com.learning.classes.parttwo.Programmer("Udin Baharudin", 5_000_000,
                new Transport(LocalDate.now(),200_000,300_000,150_000),
                new Overtime(LocalDate.now(),80_000));

        com.learning.classes.parttwo.Programmer prog2 = new com.learning.classes.parttwo.Programmer("Ujang Surajang", 12_000_000,
                new Transport(LocalDate.now(),250_000,350_000,200_000),
                new Overtime(LocalDate.now(),110_000));

        com.learning.classes.parttwo.Sales sales1 = new com.learning.classes.parttwo.Sales("Siti Raharjo", 5_500_000,
                new Commission(LocalDate.now(),500_000,300_000),
                new Overtime(LocalDate.now(),120_000));

        com.learning.classes.parttwo.QA qa1 = new com.learning.classes.parttwo.QA("Rudi Sutarno", 7_500_000,
                new Overtime(LocalDate.now(),80_000));

        return List.of(prog1, prog2, sales1, qa1);
    }

    @Override
    public void printEmployeeTwo(List<ISalary> listOfEmp) {
        for (ISalary emp : listOfEmp) {
            if (emp instanceof EmployeeTwo) {
                System.out.println(emp);
            } else {
                throw new Error("Object cannot other than EmployeeTwo");
            }
        }
    }

    @Override
    public void generateTaxAndSalaryTwo(List<ISalary> listOfEmp) {
        for (ISalary emp : listOfEmp) {
            if (emp instanceof EmployeeTwo) {
                emp.calcSalary();
                emp.calcTax();
            } else {
                throw new Error("Object cannot other than EmployeeTwo");
            }

        }
    }

}
