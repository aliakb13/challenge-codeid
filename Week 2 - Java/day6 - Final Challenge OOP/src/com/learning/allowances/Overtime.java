package com.learning.allowances;

import java.time.LocalDate;

public class Overtime extends Allowances {
    private final int hours;
    private final double overtime;
    private double totalOvertime;
    public static double sumOfOvertime;

    public Overtime(LocalDate payday, int hours, double overtime) {
        super(payday);
        this.hours = hours;
        this.overtime = overtime;
    }

    public int getHours() {
        return hours;
    }

    public double getOvertime() {
        return overtime;
    }

    public double getTotalOvertime() {
        return totalOvertime;
    }

    public void setTotalOvertime(double totalOvertime) {
        this.totalOvertime = totalOvertime;
    }
}
