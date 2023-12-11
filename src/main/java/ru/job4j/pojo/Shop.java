package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        int index;
        for (index = 0; index < products.length; index++) {
            Product product = products[index];
            if (product == null) {
                break;
            } else if (index == products.length - 1 && product != null) {
                index = -1;
                break;
            }
        }
        return index;
    }
}
