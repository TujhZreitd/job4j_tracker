package ru.job4j.cast;

public class MainVehicle {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();

        Vehicle[] vehicles = {airplane, bus, train};

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.fuel();
        }
    }
}
