package com.example.test;

public class Automobile {
    private double kmpl;
    private double fuel;
    private double tripStartFuel;

    public Automobile(double kmpl) {
        this.kmpl = kmpl;
        this.fuel = 0;
    }

    public void fillUp(double litres) {
        this.fuel += litres;
    }

    public void takeTrip(double kilometers) {
        this.tripStartFuel = this.fuel;
        this.fuel -= kilometers / this.kmpl;
    }

    public double reportFuel() {
        return this.fuel;
    }

    public double reportTripFuelUsage() {
        return this.tripStartFuel - this.fuel;
    }
}
