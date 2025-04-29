package com.learning.employee;

import com.learning.enums.Status;
import com.learning.interfaces.TaxService;
import com.learning.tax.PpnTax;

import java.time.LocalDate;

public class Freelance extends Employee implements TaxService {
    private final double projectOrder;
    private final PpnTax tax;

    public Freelance(String fullName, LocalDate hireDate, double salary, double projectOrder, PpnTax tax) {
        super(fullName, hireDate, Status.Freelance, salary);
        this.projectOrder = projectOrder;
        this.tax = tax;
    }

    public double getProjectOrder() {
        return projectOrder;
    }

    public PpnTax getPpn() {
        return tax;
    }

    @Override
    public void calcTax() {
        tax.setTotalTax(projectOrder * tax.getPpn());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + super.getEmpId() +
                ", fullName='" + super.getFullName() +
                ", hiredate=" + super.getHireDate() +
                ", status=" + super.getStatus() +
                ", totalSalary=" + getTotalSalary();

    }

    @Override
    public double getTotalSalary() {
        return projectOrder - tax.getTotalTax();
    }
}
