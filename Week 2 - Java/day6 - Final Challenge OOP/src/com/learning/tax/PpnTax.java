package com.learning.tax;

public class PpnTax {
    private final double ppn;
    private double totalTax;

    public PpnTax(double ppn) {
        this.ppn = ppn;
    }

    public double getPpn() {
        return ppn;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }
}
