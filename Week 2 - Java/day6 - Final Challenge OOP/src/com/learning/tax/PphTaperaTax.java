package com.learning.tax;

public class PphTaperaTax {
    private final double pph;
    private final double tapera;
    private double totalTax;

    public PphTaperaTax(double pph, double tapera) {
        this.pph = pph;
        this.tapera = tapera;
    }

    public double getPph() {
        return pph;
    }

    public double getTapera() {
        return tapera;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }


}
