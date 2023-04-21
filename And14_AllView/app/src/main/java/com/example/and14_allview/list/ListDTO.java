package com.example.and14_allview.list;

public class ListDTO {
    private int imgId, age;
    private  String name, gender;

    public ListDTO(int imgId, int age, String name, String gender) {
        this.imgId = imgId;
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
