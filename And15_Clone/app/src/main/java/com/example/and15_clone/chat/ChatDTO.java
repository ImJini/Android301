package com.example.and15_clone.chat;

import java.io.Serializable;

public class ChatDTO implements Serializable {
    int ImgId;
    String name, msg, tname;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
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

    public ChatDTO(int imgId, String name, String msg, String tname) {
        ImgId = imgId;
        this.name = name;
        this.msg = msg;
        this.tname =tname;
    }
}
