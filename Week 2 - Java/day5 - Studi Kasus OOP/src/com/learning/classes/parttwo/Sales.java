package com.learning.classes.parttwo;

import com.learning.Role;
import com.learning.classes.partone.salary.Commission;
import com.learning.classes.partone.salary.Overtime;
import com.learning.interfaces.ISalary;

public class Sales extends EmployeeTwo implements ISalary {
    private final Commission commission;
    private final Overtime overtime;

    public Sales(String fullName, double salary, Commission commission, Overtime overtime) {
        super(fullName, Role.Sales, salary);
        this.commission = commission;
        this.overtime = overtime;
    }

    public Commission getCommission() {
        return commission;
    }

    public Overtime getOvertime() {
        return overtime;
    }

    @Override
    public String toString() {
        return "SalesTwo{" +
                "empId=" + super.getEmpId() +
                ", fullName='" + super.getFullName() +
                ", role=" + super.getRole() +
                ", salary=" + super.getSalary() +
                ", totalSalary=" + super.getTotalSalary() +
                ", tax= " + calcTax() +
                '}';
    }

    @Override
    public double calcTax() {
        return super.getTotalSalary() * 0.5;
    }

    @Override
    public void calcSalary() {
        super.setTotalSalary(super.getSalary() +
                commission.getCommission() +
                commission.getBonus() + overtime.getMakan());
    }
}
