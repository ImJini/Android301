package com.example.and16_lastproject.conn;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.example.and16_lastproject.TestDTO;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn {

   private HashMap<String, Object> params;


   //2. ConnCallback이라는 Interface를 객체로 내가 가지고 있음.
   private ConnCallback callback;
   private Context context; //progressDialog, Toast 메시지 등을 보여줄수있게, 화면위에 그릴수 있게 Context받아옴
   private String mapping;
   private ProgressDialog dialog;

    public CommonConn(Context context, String mapping) {
        this.context = context;
        this.mapping = mapping;
        params = new HashMap<>(); //파라미터가 필요하든 안하든 일단 초기화 시킴.
    }

    public void addParam(String key, Object value){
        if (key==null){
            Log.d("CommonConn", "addParam: key null");
            return;
        } else if (value==null) {
            Log.d("CommonConn", "addParam: value null");
            return;
        }
        params.put(key, value);
    }

    //실제 enque부분 실행 전 dialog를 보여주게 함(또는 실제 요청 전 전처리가 필요하다면)
    private void onPreExcute(){
        if(context != null&&dialog==null){
            //context를 받아오고, dialog가 아직 세팅이 안된 상태
            dialog =new ProgressDialog(context);
            dialog.setProgress(ProgressDialog.STYLE_SPINNER);
            dialog.setTitle("LastProject");
            dialog.setMessage("데이터를 가져오는 중...");
            dialog.show();
        }
    }

    //3. 파라미터로 사용하는곳에서 ConnCallback을 new로 초기화 해서 넘겨준다.( new => 메모리에 어떤 공간을 공유한다.)
    public void onExcute(ConnCallback callback){
        //실행 하는 부분
        onPreExcute();
        this.callback = callback; //A == A

        ApiInterface apiInterface = Service.getApiClient().create(ApiInterface.class);
        apiInterface.getPost(mapping, params).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("테스트", "onResponse: ");
                onPostExcute(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("테스트", "onFailure: "+ t.getMessage());
                onPostExcute(false, t.getMessage());

            }
        });

    }

    //모든 실행이 (onExcute) 종료 후 실행할 코드(옵저버패턴의 메소드를 실행하는 구간?)
    private void onPostExcute(boolean isResult, String data){
        if(dialog != null){
            dialog.dismiss();
        }
        //실행

        callback.onResult(isResult, data);
    }

    //1번은 외부와 내부에서 사용할수있는 콜백의 기본형태를 만들기(메소드 형태만 만듦)

    //옵저버 패턴을 이용하기 위한 인터페이스를 만들기.(View.OnClickListner)

    public interface ConnCallback{
    public void onResult(boolean isResult, String data);

    }

    public void test(TestDTO dto){
        dto.setField1("2");
    }


}

