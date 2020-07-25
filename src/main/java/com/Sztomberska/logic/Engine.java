package com.Sztomberska.logic;

import com.Sztomberska.model.Account;
import com.Sztomberska.model.User;

import java.util.Scanner;

public class Engine {

    private User[] users = new User[10];


    public void start() {
        System.out.println("Witamy w banku. Podaj swój login: ");
        Scanner scanner = new Scanner(System.in);
        NumberGenerator generator = new NumberGenerator(users);
        String login = scanner.next();

        User checkUser = findUser(login);
        if (checkUser == null) {
            System.out.println("Konto zostało utworzone.");
            User newUser = createUser(generator, login);
            addUser(newUser);
        }
    }

    private User createUser(NumberGenerator generator, String login) {
        User newUser = new User();
        newUser.setLogin(login);
        Account newAccount = createAccount(generator);
        newUser.setAccount(newAccount);
        return newUser;
    }

    private void addUser(User newUser) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = newUser;
                break;
            }

        }
    }

    private Account createAccount(NumberGenerator generator) {
        Account newAccount = new Account();
        newAccount.setNumber(generator.generateNumber());
        newAccount.setSumOfMoney(0d);
        return newAccount;
    }

    private User findUser(String login) {
        User checkUser = null;
        for (User user : users) {
            if (user != null && login.equals(user.getLogin())) {
                checkUser = user;
                break;
            }
        }
        return checkUser;
    }

    public void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }

    }
}
