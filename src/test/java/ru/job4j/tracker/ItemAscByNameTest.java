package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void compareAsc() {
        List<Item> items = Arrays.asList(
                new Item("Egor"),
                new Item("Petr"),
                new Item("Ivan")
        );
        items.sort(new ItemAscByName());
        List<Item> result = new ArrayList<>(items);
        List<Item> expected = Arrays.asList(
                new Item("Egor"),
                new Item("Ivan"),
                new Item("Petr")
        );
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void compareDesc() {
        List<Item> items = Arrays.asList(
                new Item("Egor"),
                new Item("Petr"),
                new Item("Ivan")
        );
        items.sort(new ItemDescByName());
        List<Item> result = new ArrayList<>(items);
        List<Item> expected = Arrays.asList(
                new Item("Petr"),
                new Item("Ivan"),
                new Item("Egor")
        );
        assertThat(result).isEqualTo(expected);
    }
}