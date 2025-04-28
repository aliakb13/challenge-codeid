package com.learning.classes.partone.employee;

import com.learning.Role;
import com.learning.classes.partone.salary.Overtime;

public class QA extends Employee {
    private Overtime overtime;

    public QA(String fullName, double salary, Overtime overtime) {
        super(fullName, Role.QA, salary);
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return "QA{" +
                "empId=" + super.getEmpId() +
                ", fullName='" + super.getFullName() +
                ", role=" + super.getRole() +
                ", salary=" + super.getSalary() +
                ", totalSalary=" + super.getTotalSalary() +
                ", tax= " + super.calcTax() +
                '}';
    }

    @Override
    public void calculateSalary() {
        super.setTotalSalary(super.getTotalSalary() + overtime.getMakan());
    }
}
