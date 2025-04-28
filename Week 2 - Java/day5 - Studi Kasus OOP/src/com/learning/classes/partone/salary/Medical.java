package com.learning.classes.partone.salary;

import java.time.LocalDate;

public class Medical extends Salary {
    private double kacamata;

    public Medical(LocalDate payDay, double kacamata) {
        super(payDay);
        this.kacamata = kacamata;
    }

    public double getKacamata() {
        return kacamata;
    }
}
