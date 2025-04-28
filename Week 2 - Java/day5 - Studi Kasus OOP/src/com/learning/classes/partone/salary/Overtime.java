package com.learning.classes.partone.salary;

import java.time.LocalDate;

public class Overtime extends Salary {
    private double makan;

    public Overtime(LocalDate payDay, double makan) {
        super(payDay);
        this.makan = makan;
    }

    public double getMakan() {
        return makan;
    }
}
