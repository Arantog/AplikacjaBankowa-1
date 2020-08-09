package com.Sztomberska.logic;

import com.Sztomberska.model.Account;
import com.Sztomberska.model.User;

import com.Sztomberska.utils.IntelligentList;
import java.util.Scanner;

public class Engine {

    private final IntelligentList<User> inteligentList = new IntelligentList<>(User.class);


    public void start() {
        System.out.println("Witamy w banku. Podaj swój login: ");
        Scanner scanner = new Scanner(System.in);
        NumberGenerator generator = new NumberGenerator(inteligentList);
        String login = scanner.next();

//        User checkUser = inteligentList.find(login);
//        if (checkUser == null) {
//            System.out.println("Konto zostało utworzone.");
//            User newUser = createUser(generator, login);
//            addUser(newUser);
//        }
    }

    private User createUser(NumberGenerator generator, String login) {
        User newUser = new User();
        newUser.setLogin(login);
        Account newAccount = createAccount(generator);
        newUser.setAccount(newAccount);
        return newUser;
    }

    private void addUser(User newUser) {
       inteligentList.add(newUser);
    }

    private Account createAccount(NumberGenerator generator) {
        Account newAccount = new Account();
        newAccount.setNumber(generator.generateNumber());
        newAccount.setSumOfMoney(0d);
        return newAccount;
    }


    public void printUsers() {
        for (User user : inteligentList.getAll()) {
            System.out.println(user);
        }

    }
}
