package com.learning.classes.parttwo;

import com.learning.Role;
import com.learning.classes.partone.salary.Overtime;
import com.learning.interfaces.ISalary;

public class QA extends EmployeeTwo implements ISalary {
    private final Overtime overtime;

    public QA(String fullName, double salary, Overtime overtime) {
        super(fullName, Role.QA, salary);
        this.overtime = overtime;
    }

    public Overtime getOvertime() {
        return overtime;
    }

    @Override
    public String toString() {
        return "QaTwo{" +
                "empId=" + super.getEmpId() +
                ", fullName='" + super.getFullName() +
                ", role=" + super.getRole() +
                ", salary=" + super.getSalary() +
                ", totalSalary=" + getTotalSalary() +
                ", tax= " + calcTax() +
                '}';
    }

    @Override
    public double calcTax() {
        return super.getTotalSalary() * 0.05;
    }

    @Override
    public void calcSalary() {
        super.setTotalSalary(super.getTotalSalary() + overtime.getMakan());
    }

    @Override
    public double getTotalSalary() {
        return super.getTotalSalary() - calcTax();
    }
}
