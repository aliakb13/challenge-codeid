package com.learning.classes.employee;

import com.learning.Role;
import com.learning.classes.salary.Commission;
import com.learning.classes.salary.Overtime;

public class Sales extends Employee{
    private Commission commission;
    private Overtime overtime;

    public Sales(String fullName, double salary, Commission commission, Overtime overtime) {
        super(fullName, Role.Sales, salary);
        this.commission = commission;
        this.overtime = overtime;
    }

    @Override
    public void calculateSalary() {
        super.setTotalSalary(super.getSalary() +
                commission.getCommission() +
                commission.getBonus() + overtime.getMakan());
    }

    @Override
    public String toString() {
        return "Sales{" +
                "empId=" + super.getEmpId() +
                ", fullName='" + super.getFullName() +
                ", role=" + super.getRole() +
                ", salary=" + super.getSalary() +
                ", totalSalary=" + super.getTotalSalary() +
                ", tax= " + super.calcTax() +
                '}';
    }

    //    this for override case
//    double calcTax() {
//        return super.getTotalSalary() / 0.5;
//    }
}
