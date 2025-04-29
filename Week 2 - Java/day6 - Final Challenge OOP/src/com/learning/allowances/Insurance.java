package com.learning.allowances;

import java.time.LocalDate;

public class Insurance extends Allowances {
    private final int self;
    private final int dependant;
    private final double medical;
    private double totalInsurance;
    public static double sumOfInsurance;

    public Insurance(LocalDate payday, int self, int dependant, double medical) {
        super(payday);
        this.self = self;
        this.dependant = dependant;
        this.medical = medical;
    }

    public int getSelf() {
        return self;
    }

    public int getDependant() {
        return dependant;
    }

    public double getMedical() {
        return medical;
    }

    public double getTotalInsurance() {
        return totalInsurance;
    }

    public void setTotalInsurance(double totalInsurance) {
        this.totalInsurance = totalInsurance;
    }
}
