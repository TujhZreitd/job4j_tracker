package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("egor.yakushev.96@bk.ru", "Yakushev Egor");
        map.put("123456@mail.ru", "Ivanov Ivan");
        map.put("sidorov@mail.ru", "Sidorov Anton");
        map.put("123456@mail.ru", "Andreev Oleg");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
/**/
