package com.example.examretrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {

    @FormUrlEncoded //Java 변수로  Url을 넣어줄거다(Post방식에만 사용가능)
    @POST
        //FormUrlEncoded와 세트로 사용(url을 요청할때 Post로 요청하겠다)
    Call<String> getData(@Url String url, @FieldMap HashMap<String,String> params);
}
