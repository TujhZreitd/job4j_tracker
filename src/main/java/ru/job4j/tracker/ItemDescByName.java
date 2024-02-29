package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item itemLeft, Item itemRight) {
        return itemRight.getName().compareTo(itemLeft.getName());
    }
}
