package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского аккаунта, используемого приложением
 * @author Egor Yakushev
 *  * @version 1.0
 */

public class Account {
    /**
     * Храниние реквизитов банковского аккаунта осуществляется в переменной
     * типа String
     */
    private String requisite;
    /**
     * Храниние баланса банковского аккаунта осуществляется в переменной
     * типа double
     */
    private double balance;

    /**
     * Конструктор принимает реквизиты и баланс аккаунта и инициализирует
     * переданными значениями создаваемый аккаунт
     * @param requisite реквизиты, которые записываются в поле аккаунта requisite
     * @param balance баланс, значение которого записывается в поле аккаунта balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты аккаунта
     * @return возвращает значение поля реквизиты аккаунта
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет установить (заменить) реквизиты аккаунта на переденное в метод значение реквизитов
     * @param requisite значение реквизитов, которые принимаются на входе метода
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс аккаунта
     * @return возвращает значение поля баланса аккаунта
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет установить (заменить) значение баланса аккаунта на переданное в метод значение баланса
     * @param balance значение баланса, которое принимается на входе метода
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals для корректного сравнения аккаунтов
     * @param o объект, принимаемый на входе метода для сравнения
     * @return возращает значение типа booleаn, которое является результатом сравнения вызванного объектом метода
     * с переданным в параметрах объектом
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода hashCode для корректного сравнения аккаунтов
     * @return возвращает значение типа int, которое является результатом вызова метода hash
     * с переданным в него значением реквизитов
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
