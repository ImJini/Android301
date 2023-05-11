package com.example.and_starbucks.order;

public class BeverageDTO {
    int Beverage_Name;
    String Cof_Menu, Cof_Enname;

    public int getBeverage_Name() {
        return Beverage_Name;
    }

    public void setBeverage_Name(int beverage_Name) {
        Beverage_Name = beverage_Name;
    }

    public String getCof_Menu() {
        return Cof_Menu;
    }

    public void setCof_Menu(String cof_Menu) {
        Cof_Menu = cof_Menu;
    }

    public String getCof_Enname() {
        return Cof_Enname;
    }

    public void setCof_Enname(String cof_Enname) {
        Cof_Enname = cof_Enname;
    }

    public BeverageDTO(int beverage_Name, String cof_Menu, String cof_Enname) {
        Beverage_Name = beverage_Name;
        Cof_Menu = cof_Menu;
        Cof_Enname = cof_Enname;
    }
}
