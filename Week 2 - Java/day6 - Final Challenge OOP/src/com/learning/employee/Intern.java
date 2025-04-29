package com.learning.employee;

import com.learning.allowances.Allowances;
import com.learning.allowances.Operational;
import com.learning.enums.Status;
import com.learning.interfaces.AllowanceService;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee implements AllowanceService {
    private final List<Allowances> allowances;
//    private final PphTaperaTax tax;

    public Intern(String fullName, LocalDate hireDate, double salary, List<Allowances> allowances) {
        super(fullName, hireDate, Status.Intern, salary);
        this.allowances = allowances;
//        this.tax = tax;
    }

    public List<Allowances> getAllowances() {
        return allowances;
    }

//    public PphTaperaTax getTax() {
//        return tax;
//    }

    @Override
    public double getTotalSalary() {
        return calcAllowance();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + super.getEmpId() +
                ", fullName='" + super.getFullName() +
                ", hiredate=" + super.getHireDate() +
                ", status=" + super.getStatus() +
                ", salary=" + super.getSalary() +
                ", totalAllowance= "+ calcAllowance() +
                ", totalSalary=" + getTotalSalary() +
                '}';
    }

    @Override
    public double calcAllowance() {
        double totalAllowance = 0;
        for (Allowances allowance : allowances) {
            if (allowance instanceof Operational) {
                ((Operational) allowance).setTotalOperational(
                        (((Operational) allowance).getTransport() + ((Operational) allowance).getLunch()) * ((Operational) allowance).getDays()
                );
                totalAllowance += ((Operational) allowance).getTotalOperational();
                Operational.sumOfOperational += ((Operational) allowance).getTotalOperational();
            }
        }
        return totalAllowance;
    }

}
