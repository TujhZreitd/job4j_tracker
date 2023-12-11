package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Преступление и наказание", 1800);
        Book book2 = new Book("Братья Карамазовы", 3500);
        Book book3 = new Book("Идиот", 1500);
        Book book4 = new Book("Clean code", 1200);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getQuantityPage());
        }

        System.out.println("\nКниги с индексом 0 и 3 переставлены местами\n");

        books[0] = book4;
        books[3] = book1;

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getQuantityPage());
        }

        System.out.println("\nВывод книг с названием \"Clean code\"\n");

        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + " - " + bk.getQuantityPage());
            }
        }
    }
}
