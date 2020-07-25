package com.Sztomberska;

import com.Sztomberska.logic.Engine;
import com.Sztomberska.model.User;
import com.Sztomberska.utils.FileUtils;

public class Main {
    public static void main(String[] args){
//        Engine engine = new Engine();
//        engine.start();
//        engine.printUsers();

        // Obsługa plików
        User[] users = {new User(), new User(), new User(), new User(), new User(), new User()};
        FileUtils.save(users);

        User[] read = FileUtils.read(User[].class);
        for (User user : read) {
            System.out.println(user);
        }
    }
}
