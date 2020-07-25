package com.Sztomberska.model;

public class Account {



    private double sumOfMoney;
    private int number;

    public double getSumOfMoney() {
        return sumOfMoney;
    }

    public int getNumber() {
        return number;
    }

    public void setSumOfMoney(double sumOfMoney) {
        this.sumOfMoney = sumOfMoney;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return "Account{" +
                "sumOfMoney=" + sumOfMoney +
                ", number=" + number +
                '}';
    }
}
