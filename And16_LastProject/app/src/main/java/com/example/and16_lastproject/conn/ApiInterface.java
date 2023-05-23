package com.example.and16_lastproject.conn;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiInterface {

    @FormUrlEncoded
    @POST
    Call<String> getPost(@Url String url, @FieldMap HashMap<String, Object> params);
    //현재는 재사용가능하게 구현이 되어있는 CommonConn에는 Post방식만 요청되게 해놓음(보안성은 굿)

    //공공데이터 포털 또는 공공의 목적으로 get으로 만들어 놓은 api가 많음 , 따라서 get방식도 사용가능한
    //ApiInterface 메소드를 만들어야 함.

    @GET("{url}")
    Call<String> getDataGet(@Path("url")String url, @QueryMap HashMap<String, String>params);

    @POST("file.f")
    @Multipart /*Multipart 내부에서 enctype이 주어지면 모든 것들은 byte 형태로 데이터가 전송된다.*/
    Call<String> sendFile(@Part MultipartBody.Part file);

    @POST
    @Multipart                                                                           //HashMap<String, Part> map
    Call<String> sendFiles(@Url String url, @PartMap HashMap<String, RequestBody>maps, @Part MultipartBody.Part file);



}
