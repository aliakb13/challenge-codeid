package com.learning.classes.partone.salary;

import java.time.LocalDate;

public class Transport extends Salary {
    private double transport;
    private double spj;
    private double bensin;

    public Transport(LocalDate localDate, double transport, double spj, double bensin) {
        super(localDate);
        this.transport = transport;
        this.spj = spj;
        this.bensin = bensin;
    }

    public double getTransport() {
        return transport;
    }

    public double getSpj() {
        return spj;
    }

    public double getBensin() {
        return bensin;
    }
}
