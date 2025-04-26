package com.learning;

import com.learning.classes.employee.Employee;
import com.learning.classes.employee.Programmer;
import com.learning.classes.employee.QA;
import com.learning.classes.employee.Sales;
import com.learning.classes.salary.Commission;
import com.learning.classes.salary.Overtime;
import com.learning.classes.salary.Transport;
import com.learning.interfaces.IEmployee;

import java.time.LocalDate;
import java.util.List;

public class EmployeeImpl implements IEmployee {

    @Override
    public List<Employee> initListEmployee() {
        Programmer prog1 = new Programmer("Udin Baharudin", 5_000_000,
                new Transport(LocalDate.now(),200_000,300_000,150_000),
                new Overtime(LocalDate.now(),80_000));

        Programmer prog2 = new Programmer("Ujang Subagja", 12_000_000,
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

}
