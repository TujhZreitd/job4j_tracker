package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item object = new Item();
        LocalDateTime resultNotFormat = object.getCreated();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String resultFormat = resultNotFormat.format(formatter);
        System.out.println(resultFormat);

    }
}
