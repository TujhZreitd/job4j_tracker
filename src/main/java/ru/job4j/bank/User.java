package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского пользователя
 *  @author Egor Yakushev
 *  @version 1.0
 */
public class User {
    /**
     * Хранение значения паспорта осуществляется в переменной типа String
     */
    private String passport;
    /**
     * Хранение значения имени пользователя осуществляется в переменной типа String
     */
    private String username;

    /**
     * Конструктор принимает на вход значения паспорта и имя пользователя для создания нового пользователя
     * @param passport в конструктор передается значение паспорта для инициализации
     * @param username в конструктор передается значение имени для инициализации
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод возвращает значение паспорта пользователя
     * @return значение поля passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает значение, на которое перезаписывает значение паспорта пользователя
     * @param passport в метод передается значение паспорта, которое будет перезаписано у пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает значение имени пользователя
     * @return значение поля username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает значение, на которое перезаписывает значение имени пользователя
     * @param username в метод передается значение имени, которое будет перезаписано у пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода equals для корректного сравнения пользователей
     * @param o объект, который передается в метод для сравнения
     * @return переменная типа boolean, обозначающая результат сравнения объектов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода hashCode для корректного сравнения пользователей
     * @return возвращает значение типа int, которое является результатом вызова метода hash
     * с переданным в него значением паспорта
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
