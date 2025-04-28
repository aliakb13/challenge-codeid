package com.learning.classes.partone.employee;

import com.learning.Role;
import com.learning.classes.partone.salary.Overtime;
import com.learning.classes.partone.salary.Transport;

public class Programmer extends Employee {
    private Transport transport;
    private Overtime overtime;

    public Programmer(String fullName, double salary, Transport transport, Overtime overtime) {
        super(fullName, Role.Programmer, salary);
        this.transport = transport;
        this.overtime = overtime;
    }

    public Transport getTransport() {
        return transport;
    }

    public Overtime getOvertime() {
        return overtime;
    }

//    this for override case
//    double calcTax() {
//        return super.getTotalSalary() / 0.5;
//    }


    @Override
    public String toString() {
        return "Programmer{" +
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
        super.setTotalSalary(super.getSalary() + transport.getTransport() + transport.getSpj() + transport.getBensin() + overtime.getMakan());
    }
}
