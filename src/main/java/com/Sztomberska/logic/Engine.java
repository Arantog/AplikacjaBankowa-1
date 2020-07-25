package com.Sztomberska.logic;

import com.Sztomberska.model.Account;
import com.Sztomberska.model.User;

import com.Sztomberska.utils.UserList;
import java.util.Scanner;

public class Engine {

    private UserList userList = new UserList();


    public void start() {
        System.out.println("Witamy w banku. Podaj swój login: ");
        Scanner scanner = new Scanner(System.in);
        NumberGenerator generator = new NumberGenerator(userList.getAll());
        String login = scanner.next();

        User checkUser = userList.findUser(login);
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
       userList.addUser(newUser);
    }

    private Account createAccount(NumberGenerator generator) {
        Account newAccount = new Account();
        newAccount.setNumber(generator.generateNumber());
        newAccount.setSumOfMoney(0d);
        return newAccount;
    }


    public void printUsers() {
        for (User user : userList.getAll()) {
            System.out.println(user);
        }

    }
}
