package com.example.and_starbucks.pay;

public class PayDTO {
    int CardId, Bacode;
    String CardName, Cardmoney, BacodeTime;

    public int getCardId() {
        return CardId;
    }

    public void setCardId(int cardId) {
        CardId = cardId;
    }

    public int getBacode() {
        return Bacode;
    }

    public void setBacode(int bacode) {
        Bacode = bacode;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public String getCardmoney() {
        return Cardmoney;
    }

    public void setCardmoney(String cardmoney) {
        Cardmoney = cardmoney;
    }

    public String getBacodeTime() {
        return BacodeTime;
    }

    public void setBacodeTime(String bacodeTime) {
        BacodeTime = bacodeTime;
    }

    public PayDTO(int cardId, int bacode, String cardName, String cardmoney, String bacodeTime) {
        CardId = cardId;
        Bacode = bacode;
        CardName = cardName;
        Cardmoney = cardmoney;
        BacodeTime = bacodeTime;
    }
}
