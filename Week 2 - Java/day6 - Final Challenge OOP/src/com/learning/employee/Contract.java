package com.learning.employee;

import com.learning.allowances.Allowances;
import com.learning.allowances.Insurance;
import com.learning.allowances.Operational;
import com.learning.allowances.Overtime;
import com.learning.enums.Status;
import com.learning.interfaces.AllowanceService;
import com.learning.interfaces.TaxService;
import com.learning.tax.PphTaperaTax;

import java.time.LocalDate;
import java.util.List;

public class Contract extends Employee implements AllowanceService, TaxService {
    private final List<Allowances> allowances;
    private final PphTaperaTax tax;

    public Contract(String fullName, LocalDate hireDate, double salary, List<Allowances> allowances, PphTaperaTax tax) {
        super(fullName, hireDate, Status.Contract, salary);
        this.allowances = allowances;
        this.tax = tax;
    }

    public List<Allowances> getAllowances() {
        return allowances;
    }

    public PphTaperaTax getTax() {
        return tax;
    }

    @Override
    public double getTotalSalary() {
        return super.getSalary() - (calcAllowance() + tax.getTotalTax());
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
                ", totalTax= " + tax.getTotalTax() +
                ", totalSalary=" + getTotalSalary() +
                '}';
    }

    @Override
    public double calcAllowance() {
        double totalAllowance = 0;
        for (Allowances allowance : allowances) {
            if (allowance instanceof Insurance) {
                ((Insurance) allowance).setTotalInsurance(
                        (super.getSalary() * ((Insurance) allowance).getMedical()) *
                                (((Insurance) allowance).getSelf() + ((Insurance) allowance).getDependant())
                );

                totalAllowance = ((Insurance) allowance).getTotalInsurance();
                Insurance.sumOfInsurance += ((Insurance) allowance).getTotalInsurance();
            }

            if(allowance instanceof Overtime) {
                ((Overtime) allowance).setTotalOvertime(
                        ((Overtime) allowance).getHours() * ((Overtime) allowance).getOvertime()
                );
                totalAllowance -= ((Overtime) allowance).getTotalOvertime();
                Overtime.sumOfOvertime += ((Overtime) allowance).getTotalOvertime();

            }

            if (allowance instanceof Operational) {
                ((Operational) allowance).setTotalOperational(
                        (((Operational) allowance).getTransport() + ((Operational) allowance).getLunch()) * ((Operational) allowance).getDays()
                );
                totalAllowance -= ((Operational) allowance).getTotalOperational();
                Operational.sumOfOperational += ((Operational) allowance).getTotalOperational();

            }
        }
        return totalAllowance;
    }

    @Override
    public void calcTax() {
        tax.setTotalTax((super.getSalary() * tax.getPph()) + (super.getSalary() * tax.getTapera()));
    }
}
