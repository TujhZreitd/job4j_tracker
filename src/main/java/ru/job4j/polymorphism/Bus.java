package ru.job4j.polymorphism;

public class Bus implements Transport {

    private int passengers;
    private final double priceOil = 40.0;

    @Override
    public void drive() {
        System.out.println("Drive");
    }

    @Override
    public void passengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public double refill(double oil) {
        return oil * priceOil;
    }
}
