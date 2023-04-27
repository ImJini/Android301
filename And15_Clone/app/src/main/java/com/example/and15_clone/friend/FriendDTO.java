package com.example.and15_clone.friend;

import java.io.Serializable;

public class FriendDTO implements Serializable {
    int imgId;//이미지용

    String name, msg; //텍스트뷰 용

    public FriendDTO(int imgId, String name, String msg) {
        this.imgId = imgId;
        this.name = name;
        this.msg = msg;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
