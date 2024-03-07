package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] attachments = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());
        Arrays.sort(attachments, comparator);
        Comparator<Attachment> comparatorText = (left, right) -> left.getName().compareTo(right.getName());
        Comparator<Attachment> comparatorDescSize = (left, right) -> Integer.compare(right.getSize(), left.getSize());
    }

}
