package com.learning.allowances;

import java.time.LocalDate;

public class Operational extends Allowances {
    private final int days;
    private final int lunch;
    private final int transport;
    private double totalOperational;
    public static double sumOfOperational;

    public Operational(LocalDate payday, int days, int lunch, int transport) {
        super(payday);
        this.days = days;
        this.lunch = lunch;
        this.transport = transport;
        sumOfOperational += totalOperational;
    }

    public int getDays() {
        return days;
    }

    public int getLunch() {
        return lunch;
    }

    public int getTransport() {
        return transport;
    }

    public double getTotalOperational() {
        return totalOperational;
    }

    public void setTotalOperational(double totalOperational) {
        this.totalOperational = totalOperational;
    }
}
