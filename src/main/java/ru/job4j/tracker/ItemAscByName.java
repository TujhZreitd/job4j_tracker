package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item itemLeft, Item itemRight) {
        return itemLeft.getName().compareTo(itemRight.getName());
    }
}
