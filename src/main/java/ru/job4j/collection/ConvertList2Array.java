package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0;
        int cell = 0;
        for (Integer number : list) {
            array[row][cell] = number;
            cell += 1;
            if (cell >= cells) {
                cell = 0;
                row += 1;
            }
        }
        return array;
    }
}
