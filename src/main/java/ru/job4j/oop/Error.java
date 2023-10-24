package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() { }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Состояние: " + active);
        System.out.println("Cтатус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error validation = new Error();
        Error name = new Error(true, 1, "Не правильно задано имя переменной");
        Error age = new Error(true, 2, "Выход за пределы допустимого значения возраста");
        validation.printInfo();
        name.printInfo();
        age.printInfo();
    }

}
