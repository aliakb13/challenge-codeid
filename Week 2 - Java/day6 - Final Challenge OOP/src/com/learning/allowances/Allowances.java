package com.learning.allowances;

import java.time.LocalDate;

abstract public class Allowances {
    private final LocalDate payday;

    public Allowances(LocalDate payday) {
        this.payday = payday;
    }

    public LocalDate getPayday() {
        return payday;
    }
}
