package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result1 = right.split("/")[0].compareTo(left.split("/")[0]);
        int result2 = left.compareTo(right);
        return result1 == 0 ? result2 : result1;
    }
}