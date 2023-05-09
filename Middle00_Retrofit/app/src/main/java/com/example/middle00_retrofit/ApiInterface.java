package com.example.middle00_retrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiInterface {
    //Call객체가 나옴(Retrofit용)
    //Call객체와 url, 파라미터등을 미리 interface 형태로 만드는데 , Retrofit의 어노테이션을 달아서
    //Retrofit API가 요구한 형태로 만들어야 한다(방법)

    @FormUrlEncoded //Java 변수로  Url을 넣어줄거다(Post방식에만 사용가능)
    @POST //FormUrlEncoded와 세트로 사용(url을 요청할때 Post로 요청하겠다)
    Call<String> getData(@Url String url, @FieldMap HashMap<String,String> params);
}
