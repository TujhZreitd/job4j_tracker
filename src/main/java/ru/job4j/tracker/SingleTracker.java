package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleTracker {
    private Tracker tracker = new Tracker();
    private static SingleTracker singleton = null;

    private SingleTracker() {

    }

    public static SingleTracker getSingleton() {
        if (singleton == null) {
            singleton = new SingleTracker();
        }
        return singleton;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public int indexOf(int id) {
        return tracker.indexOf(id);
    }

    public ArrayList<Item> findAll() {
        return tracker.findAll();
    }

    public ArrayList<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}
