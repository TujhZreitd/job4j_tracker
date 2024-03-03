package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

/**
 * Класс описывает работу банковского приложения
 * @author Egor Yakushev
 *  * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей приложения осуществляется в коллекции типа Map с реализацией HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в коллекцию
     * При этом происходит проверка по паспорту пользователя, чтобы один пользователь не мог быть добавлен несколько раз
     * @param user пользователь, который добавляется в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход значение паспорта, по которому находит пользователя и удаляет его из коллекции
     * @param passport значение паспорта, которое передается в метод
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод принимает на вход значение паспорта и объект типа Account, проверяет
     * имеется ли такой пользователь в коллекции, проверяет имеется ли такой аккаунт,
     * после чего добавляет переданный аккаунт
     * @param passport значение паспорта, которое передается в метод для поиска пользователя
     * @param account объект типа Account, который передается в метод для записи
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход значение паспорта, по которому производит поиск пользователя
     * @param passport значение паспорта, которое передается в метод для поиска пользователя
     * @return возвращает найденного пользователя, если такой имеется в коллекции
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает значения паспорта и реквизитов, по которым ищет аккаунт у конкретного пользователя.
     * Если аккаунт не найден, возвращает null
     * @param passport значение паспорта, которое передается в метод для поиска пользователя
     * @param requisite значение реквизитов, которое передается в метод для поиска аккаунта
     * @return возвращает найденный аккаунт, либо null в случае его отсутствия
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает значения паспорта и реквизитов аккаунта разных пользователей
     * для осуществления перевода денежных средств
     * @param sourcePassport в метод передается значение паспорта пользователя, который хочет сделать перевод
     * @param sourceRequisite в метод передается значение реквизитов для поиска аккаунта, с которого будет сделан перевод
     * @param destinationPassport в метод передается значение паспорта пользователя, которому хотят сделать перевод
     * @param destinationRequisite в метод передается значение реквизитов для поиска аккаунта, на который юудет сделан перевод
     * @param amount в метод передается значение суммы, которая будет переведена
     * @return значение типа boolean, true если перевод успешен, false если перевод не произошел
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);
        if (source == null
                || destination == null
                || source.getBalance() < amount) {
            return false;
        }
        source.setBalance(source.getBalance() - amount);
        destination.setBalance(destination.getBalance() + amount);
        return true;
    }

    /**
     * Метод принимает пользователя и возвращает все его аккаунты
     * @param user пользователь, передаваемый в метод
     * @return коллекцию аккаунтов переданного пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
