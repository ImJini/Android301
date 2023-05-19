package com.example.and16_lastproject.godata;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class GoDTO {

    private int id;
    private double lat, lng;
    private String localSpecialStNm, localSpecialStIntro, addrRoad, addrJibun;

}
