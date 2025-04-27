package com.learning.classes.partone.salary;

import java.time.LocalDate;

abstract public class Salary {
    private LocalDate payDay;

    public Salary(LocalDate payDay) {
        this.payDay = payDay;
    }

    public LocalDate getPayDay() {
        return payDay;
    }
}
