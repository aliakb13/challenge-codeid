package com.learning;

import com.learning.allowances.Insurance;
import com.learning.allowances.Operational;
import com.learning.allowances.Overtime;
import com.learning.employee.*;
import com.learning.interfaces.AllowanceService;
import com.learning.interfaces.TaxService;
import com.learning.tax.PphTaperaTax;
import com.learning.tax.PpnTax;

import java.time.LocalDate;
import java.util.List;

public class HRServiceImpl implements HRService {


    @Override
    public List<Employee> initEmployee() {
        Permanent emp1 = new Permanent("Anton", LocalDate.of(2020,4,2),20_000_000,
                List.of(new Insurance(LocalDate.now(),1,2, 0.02),
                        new Overtime(LocalDate.now(),10,50_000),
                        new Operational(LocalDate.now(),2,30_000,20_000)),
                new PphTaperaTax(0.005,0.005));

        Permanent emp2 = new Permanent("Budi", LocalDate.of(2021,4,2),15_000_000,
                List.of(new Insurance(LocalDate.now(),1,3, 0.02),
                        new Overtime(LocalDate.now(),5,50_000)),
                new PphTaperaTax(0.005,0.005));

        Contract emp3 = new Contract("Charlie", LocalDate.of(2022,4,2),15_000_000,
                List.of(new Insurance(LocalDate.now(),1,0, 0.02),
                        new Overtime(LocalDate.now(),5,45_000)),
                new PphTaperaTax(0.005,0.005));

        Contract emp4 = new Contract("Dian", LocalDate.of(2023,4,2),10_000_000,
                List.of(new Insurance(LocalDate.now(),1,0, 0.02),
                        new Overtime(LocalDate.now(),6,45_000)),
                new PphTaperaTax(0.005,0.005));

        Intern emp5 = new Intern("Gita",LocalDate.of(2024,2,4),0,
                List.of(new Operational(LocalDate.now(),25,30_000,20_000)));
//
        Freelance emp6 = new Freelance("Rima",LocalDate.of(2025,2,4),0, 25_000_000,
                new PpnTax(0.025));

        return List.of(emp1, emp2, emp3, emp4,emp5, emp6);

    }

    public void generateTotalSalary(List<Employee> listOfEmp) {
        for (Employee emp : listOfEmp) {
            if (emp instanceof Permanent || emp instanceof Contract) {
                ((AllowanceService) emp).calcAllowance();
                ((TaxService) emp).calcTax();
            } else if (emp instanceof Intern) {
                ((Intern) emp).calcAllowance();
            } else {
                ((Freelance) emp).calcTax();
            }
        }
    }

    public void displayEmployee(List<Employee> listOfEmp) {
        for (Employee emp : listOfEmp) {
            System.out.println(emp);
        }
    }

    public void summary(List<Employee> listOfEmp) {
//        double totalSalary = 0;
//        double totalInsurance = 0;
//        double totalOvertime = 0;
//        double totalOperational = 0;
//        double totalTax = 0;
//
//        for (Employee emp : listOfEmp) {
//            totalSalary += emp.getTotalSalary();
//
//        }

        System.out.println("Total Employee = " + Employee.totalEmployee);
        System.out.println("Total Salary = " + Employee.sumOfSalary);
        System.out.println("Total Insurance = " + Insurance.sumOfInsurance);
        System.out.println("Total Overtime = " + Overtime.sumOfOvertime);
        System.out.println("Total Operational = " + Operational.sumOfOperational);
//        System.out.println("Total Tax = " + totalTax);
    }


}
