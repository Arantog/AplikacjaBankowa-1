package com.Sztomberska.logic;

import com.Sztomberska.model.User;
import com.Sztomberska.utils.IntelligentList;

public class NumberGenerator {

    private int number = 0;

    public NumberGenerator(IntelligentList<User> users) {
        for (User user : users.getAll()) {
            if (user != null && user.getAccount().getNumber() > number) {
                number = user.getAccount().getNumber();
            }
        }
    }
    public int generateNumber (){
        return number++;
    }
}

