package com.example.vendingmachine;

import java.io.Serializable;

public class SodaDTO implements Serializable {
    private int money;
    private int soda;

    public int getSoda() {
        return soda;
    }

    public void setSoda(int soda) {
        this.soda = soda;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
