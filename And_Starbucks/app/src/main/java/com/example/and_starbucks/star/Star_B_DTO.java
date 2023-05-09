package com.example.and_starbucks.star;

import java.io.Serializable;

public class Star_B_DTO implements Serializable {
    int ImgId;

    String bvName;

    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }

    public String getBvName() {
        return bvName;
    }

    public void setBvName(String bvName) {
        this.bvName = bvName;
    }

    public Star_B_DTO(int imgId, String bvName) {
        ImgId = imgId;
        this.bvName = bvName;
    }
}
