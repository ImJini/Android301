package com.example.and16_lastproject.godata;

import com.google.gson.annotations.SerializedName;

public class GoDTO {

    @SerializedName("localSpacialStNm")
            String stName;
    @SerializedName("localSpecialStIntro")
            String stIntro;

    String id, addrRoad, addrJibun, lat, lng, ttlLng, storeCnt, dsgnYear, mngAgcTel, mngAgcNm, syncTime;

}
