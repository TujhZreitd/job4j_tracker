package ru.job4j.pojo;

public class Book {
    private String name;
    private int quantityPage;

    public Book(String name, int quantityPage) {
        this.name = name;
        this.quantityPage = quantityPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityPage() {
        return quantityPage;
    }

    public void setQuantityPage(int quantityPage) {
        this.quantityPage = quantityPage;
    }
}
