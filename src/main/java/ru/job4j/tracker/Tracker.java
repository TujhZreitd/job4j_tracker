package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        /*Item[] result = new Item[size];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item != null) {
                result[index] = item;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;*/
        return items;
    }
    /* свое начальное решение, по логике тоже неправильное, я решил закомментировать, чтобы была возможность проверить
    * его правильность */

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int sizeResult = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                result[index] = item;
                sizeResult++;
            }
        }
        result = Arrays.copyOf(result, sizeResult);
        /* по логике, здесь как будто напрашивалось приминение метода findAll, не вводя переменную sizeResult,
        * но из-за нелогичного теста на метод findAll, который ввел меня в дикое заблуждение, решил так.
        * Либо я, просидев около 3 часов над данным решением, совсем запутался в теме. Если в ответе развернуто напишите,
        * как тут все работает и в чем я не прав, буду благодарен */
        return result;
    }
}