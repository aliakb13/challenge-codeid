package com.learning.classes.salary;

import java.time.LocalDate;

public class Commission extends Salary {
    private double bonus;
    private double commission;

    public Commission(LocalDate payDay, double bonus, double commission) {
        super(payDay);
        this.bonus = bonus;
        this.commission = commission;
    }

    public double getBonus() {
        return bonus;
    }

    public double getCommission() {
        return commission;
    }
}
