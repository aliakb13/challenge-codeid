package com.learning.classes.parttwo;

import com.learning.Role;
import com.learning.classes.partone.salary.Overtime;
import com.learning.classes.partone.salary.Transport;
import com.learning.interfaces.ISalary;

public class Programmer extends EmployeeTwo implements ISalary {
    private final Transport transport;
    private final Overtime overtime;

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

    @Override
    public String toString() {
        return "ProgrammerTwo{" +
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
        super.setTotalSalary(super.getSalary() + transport.getTransport() + transport.getSpj() + transport.getBensin() + overtime.getMakan());
    }

    @Override
    public double getTotalSalary() {
        return super.getTotalSalary() - calcTax();
    }
}
