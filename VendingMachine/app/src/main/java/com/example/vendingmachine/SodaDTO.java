package com.example.vendingmachine;

import java.io.Serializable;

public class SodaDTO implements Serializable {
    private String name;
    private int cnt;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCnt() {
        return cnt;
    }

    public void buy() {
        this.cnt = this.cnt - 1;
    }
    public void plus() {
        this.cnt = this.cnt + 1;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SodaDTO(String name, int cnt, int price) {
        this.name = name;
        this.cnt = cnt;
        this.price = price;
    }
}
