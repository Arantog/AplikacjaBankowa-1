package com.Sztomberska;

import com.Sztomberska.logic.Engine;

public class Main {
    public static void main(String[] args){
        Engine engine = new Engine();
        engine.start();
        engine.printUsers();
    }
}
