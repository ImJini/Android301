package com.example.and16_lastproject.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.and16_lastproject.MainActivity;
import com.example.and16_lastproject.R;
import com.example.and16_lastproject.common.CommonVal;
import com.example.and16_lastproject.conn.ApiInterface;
import com.example.and16_lastproject.conn.CommonConn;
import com.example.and16_lastproject.conn.Service;
import com.example.and16_lastproject.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.user.UserApiClient;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {

    //네이티브 앱 키 : ab66c12b72881a76b03ce45cbaa4d8bf

    //네이버 client id : 0BD1e6sy1pBHyFqhxsTO
    //sec : 16cY7k74TT
    //이름 : And16_LastProject

    ActivityLoginBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getHashKey();
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        //saveLoginInfo();
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String id = preferences.getString("id", "--");
        String pw = preferences.getString("pw", "--");
        String str = preferences.getString("str", "--");

        binding.edtId.setText(id);
        binding.edtPw.setText(pw);

        /*Log.d("공유자원", "onCreate: "+id);
        Log.d("공유자원", "onCreate: "+pw);
        Log.d("공유자원", "onCreate: "+str);*/

        Function2<OAuthToken, Throwable, Unit> callback=  new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken != null){
                    Log.d("카카오톡", "invoke: true"+oAuthToken);
                }
                if (throwable !=null){
                    Log.d("카카오톡", "invoke: true"+throwable.getMessage());
                }
                return null;
            }
        };

        binding.tvJoin.setOnClickListener(v->{
            Intent intent= new Intent(this, JoinActivity.class);
            startActivity(intent);
        });


        //kakao 로그인 ======
        KakaoSdk.init(this, "ab66c12b72881a76b03ce45cbaa4d8bf");
        binding.imgvKakao.setOnClickListener(v->{

          /*  //UserApiClient.instance.logout{ error->
            UserApiClient.getInstance().logout(throwable -> {
                if(throwable != null){
                    Log.d("카카오톡", "onCreate: 로그아웃 성공?");
                }else{
                    Log.d("카카오톡", "onCreate: 로그아웃 실패??"+throwable.getMessage());
                }
                return null;
            });*/

            //네이버 로그인 ======
            NaverIdLoginSDK.INSTANCE.initialize(
                    this, "0BD1e6sy1pBHyFqhxsTO",
                    "16cY7k74TT",
                    "And16_LastProject"
            );

            binding.buttonOAuthLoginImg.setOAuthLogin(new OAuthLoginCallback() {
                @Override
                public void onSuccess() {
                    Log.d("네이버 로그인", "onSuccess: "+NaverIdLoginSDK.INSTANCE.getAccessToken());
                    naverProfile();

                }

                @Override
                public void onFailure(int i, @NonNull String s) {
                    Log.d("네이버 로그인", "onFailure: "+s);
                }

                @Override
                public void onError(int i, @NonNull String s) {
                    Log.d("네이버 로그인", "onError: "+s);

                }
            });




            //네이버 로그인 =======



            if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(this)){
                Log.d("카카오톡", "onCreate: true");
                UserApiClient.getInstance().loginWithKakaoTalk(this, callback);//카카오앱
            }else{
                Log.d("카카오톡", "onCreate: false");
                UserApiClient.getInstance().loginWithKakaoAccount(this, callback);//인터넷
            }
        });



/*
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.rx.loginWithKakaoTalk(context)
                    .observeOn(AndroidSchedulers.mainThread())
                    .onErrorResumeNext { error ->
                // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                    Single.error(error)
                } else {
                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.rx.loginWithKakaoAccount(context)
                }
            }.observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ token ->
                            Log.i(TAG, "로그인 성공 ${token.accessToken}")
                    }, { error ->
                            Log.e(TAG, "로그인 실패", error)
                    }).addTo(disposables)
        } else {
            UserApiClient.rx.loginWithKakaoAccount(context)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ token ->
                            Log.i(TAG, "로그인 성공 ${token.accessToken}")
                    }, { error ->
                            Log.e(TAG, "로그인 실패", error)
                    }).addTo(disposables)
        }
*/



        binding.bntLogin.setOnClickListener(v->{
        CommonConn conn = new CommonConn(this, "login.mem");
        conn.addParam("id", binding.edtId.getText().toString());
        conn.addParam("pw", binding.edtPw.getText().toString());


            //로그인을 성공했을때만 저장 할 것인지??
            //saveLoginInfo();

            if(binding.chkLogin.isChecked()){
                saveLoginInfo();
            }else{
                //saveLoginInfo(); //메소드를 변형하여 빈값을 저장하거나 삭제 처리.
            }

            //실행
            conn.onExcute((isResult, data) -> {
                Log.d("로그인", "onCreate: "+data);
                CommonVal.loginInfo = new Gson().fromJson(data, AndMemberVO.class);

                if(CommonVal.loginInfo != null){
                Log.d("로그인", "onCreate: "+ CommonVal.loginInfo.getName());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                //MainActivity로 전환
                }else {
                    Toast.makeText(this,"아이디 또는 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                }
            });
            //CommonConn클래스를 이용하여 Spring의 login.mem이라는 맵핑을 요청하고, Edittext에 있는  id와 pw 전송해보기
            //Spring 콘솔에 Android Edittext에 있던 글자가 찍히면 완료


        });
    }

    private void naverProfile(){
        //NidOu
        NidOAuthLogin authLogin = new NidOAuthLogin();
        authLogin.callProfileApi(new NidProfileCallback<NidProfileResponse>() {
            @Override
            public void onSuccess(NidProfileResponse nidProfileResponse) {
                Log.d("네이버", "onSuccess: "+nidProfileResponse.getProfile().getEmail());
                Log.d("네이버", "onSuccess: "+nidProfileResponse.getProfile().getName());
                Log.d("네이버", "onSuccess: "+nidProfileResponse.getProfile().getMobile());
            }

            @Override
            public void onFailure(int i, @NonNull String s) {

            }

            @Override
            public void onError(int i, @NonNull String s) {

            }
        });
    }

    private void kakaoProfile(){
        //UserApiClient.instance.me -> ?
        UserApiClient.getInstance().me((user, throwable) -> {
            if(throwable != null){
                //오류가 발생해서 어떤 오류인지 코드로 제공해줌 (KOE+숫자)
                Log.d("프로필", "kakaoProfile: "+throwable.getMessage());
            }else{
                Log.d("프로필 정보", "kakaoProfile: "+user.getKakaoAccount().getEmail());
                Log.d("프로필 정보", "kakaoProfile: "+user.getKakaoAccount().getName());
                Log.d("프로필 정보", "kakaoProfile: "+user.getKakaoAccount().getPhoneNumber());
                Log.d("프로필 정보", "kakaoProfile: "+user.getKakaoAccount().getProfile().getNickname());
                Log.d("프로필 정보", "kakaoProfile: "+user.getKakaoAccount().getProfile().getThumbnailImageUrl());
                Log.d("프로필 정보", "kakaoProfile: "+user.getKakaoAccount().getProfile().getProfileImageUrl());
                //Spring으로 email정보를 전송하여 후 처리를 하면 된다.
                //1. email을 따로 DB컬럼을 이용해서 저장한다.
                //2. email을 id로 두고 DB를 통해 조회해서 이미 있는지 없는지 여부에 따라서 회원가입을 시키거나 로그인 처리를 함.
                //

            }

            return null;
        });
    }


    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

    private void saveLoginInfo(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        //공유자원 : SharedPreferences . 휴대폰의 데이터를 로컬에 저장하는 용도
        //간단한 id 와 pw등의 정보를 저장할때 쓴다 단점  => 휴대폰 캐시를 비우게 되면 정보가 없어짐
        //데이터를 공유자원에 쓸때 => Editor(SharedPreferences)
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("id",binding.edtId.getText().toString());
        editor.putString("pw",binding.edtPw.getText().toString());
        editor.apply(); //저장처리 완료 부분

    }


}