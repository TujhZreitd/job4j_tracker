package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по скоростным трассам.");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " заправляется бензином.");
    }
}
