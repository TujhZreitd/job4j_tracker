package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху.");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " заправляется керосином.");
    }
}
