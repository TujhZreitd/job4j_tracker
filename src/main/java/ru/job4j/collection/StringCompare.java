package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int refIter;
        int l = Integer.compare(left.length(), right.length());
        if (l > 0) {
            refIter = right.toCharArray().length;
        } else {
            refIter = left.toCharArray().length;
        }
        for (int i = 0; i < refIter; i++) {
            if (Character.compare(left.charAt(i), right.charAt(i)) < 0) {
                result = -1;
            } else if (Character.compare(left.charAt(i), right.charAt(i)) > 0) {
                result = 1;
            }
        }
        if (result == 0) {
            result = l;
        }
        return result;
    }
}
