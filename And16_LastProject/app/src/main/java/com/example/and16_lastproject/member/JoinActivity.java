package com.example.and16_lastproject.member;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.and16_lastproject.R;
import com.example.and16_lastproject.conn.ApiInterface;
import com.example.and16_lastproject.conn.Service;
import com.example.and16_lastproject.databinding.ActivityJoinBinding;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

public class JoinActivity extends AppCompatActivity {

    ActivityJoinBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= ActivityJoinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        checkDangerousPermissions();

        binding.imgvProfile.setOnClickListener(v->{
            showDialog();

        });
    }

    //프로필 사진을 사용자가 업로드를 하는데, 미리찍어둔 갤러리 이미지를 이용할 것인지, 카메라를 이용할 것인지를
    //선택받아서 방법을 분기한다.
    String [] dialog_item={"카메라", "갤러리"};

    final int GALLERY_REQ = 1001;


    String imgFilePath = null;
    private File createFile(){
        String timeStamp =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName= "And16Pj" +timeStamp;
        //사진파일을 저장하기 위한 임시경로(메소드 통해서 받아오기)
        //기능이 버전이 올라가서 안되는 경우 다시 찾아봐야 함 // 외우기 ㄴㄴ 복붙해서 쓰자
        File storageDir= getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File rtnFile = null;

        try {
            rtnFile = File.createTempFile(fileName, ".jpg", storageDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imgFilePath = rtnFile.getAbsolutePath(); //emlet

        return rtnFile;


    }
    final int CAMERA_CODE = 1500;
    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("선택하세요")
                .setSingleChoiceItems(dialog_item, -1, (dialogInterface, i) -> {
                  if(dialog_item[i].equals("카메라")){
                      //createFile <- 임시로 파일을 만들어 내용제공자로부터 받을수있게 해야한다.
                      //AndroidVersion N이상부터는 필수 (24)
                      Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                      //임시파일을 만들고 <- 프로바이더로 임시파일을 같이 보내서 가져오게 만듦
                      //인텐트가 사용가능한지 여부가 체크가 필요

                      if(intent.resolveActivity(getPackageManager()) != null){
                          File file = createFile();
                          if(file != null){
                              //Api24부터의 로직엔 파일이 필요
                              Uri imgUri = FileProvider.getUriForFile(getApplicationContext(),
                                      getApplicationContext().getPackageName()+ ".fileprovider", file);
                              //프로바이더를 통해서 임시파일을 인증을 받아 카메라 액티비티에게 받을 준비를 끝냄

                              if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                                  intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
                              }else {
                                  intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                              }
                            startActivityForResult(intent, CAMERA_CODE);



                          }
                      }





                  } else if (dialog_item[i].equals("갤러리")) {
                    //갤러리나 카메라 등에서 어떤 결과물을 얻어오는 방식은 매번 바뀐다.
                      //보안 정보가 업데이트 되는 경우
                      //갤러리 = > 액티비티
                      Intent intent = new Intent();
                      intent.setType("image/*");
                      intent.setAction(Intent.ACTION_PICK);
                      startActivityForResult(
                              Intent.createChooser(intent,"사진 고르세요"), GALLERY_REQ
                      );

                  }else{
                      Toast.makeText(this, "오류입력 다시 선택", Toast.LENGTH_SHORT).show();
                  }

                });
                AlertDialog dialog = builder.create();
                dialog.show(); //여기빠지면 눈에 안보임.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQ && resultCode ==RESULT_OK){
            //Intent data <=를 통해서 선택 된 이미지를 쓸수있게 경로를 제공
            //보안상에 문제로 가짜 이미지 Url만 제공이 된다  =>Cursor를 이용해서 실행
            Log.d("갤러리", "onActivityResult: "+data.getData());
            Log.d("갤러리", "onActivityResult: "+data.getData().getPath());
            String realPath = getRealPath(data.getData());
            Log.d("갤러리", "onActivityResult: "+"");
            //Glide.with(this).load(binding.imgvProfile).load(realPath);
            Glide.with(this).load(realPath).into(binding.imgvProfile);

            //Multipart 형태로 전송 ~File~ : Retrofit Api 규칙에 맞춰서 사용
            //Form태그를 동적으로 만들어서 어떤 전송처리를 한다=>
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(realPath));//폼태그안에 파일이 들어갔다.
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
            ApiInterface apiInterface = Service.getApiClient().create(ApiInterface.class);


            AndMemberVO vo = new AndMemberVO();
            vo.setName("임세진");
            apiInterface.sendFile(filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("TAG", "onResponse: "+response.body());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("TAG", "onResponse: "+t.getMessage());

                }
            });

        } else if (requestCode ==CAMERA_CODE && resultCode ==RESULT_OK) {
            Glide.with(this).load(imgFilePath).into(binding.imgvProfile);
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(imgFilePath));//폼태그안에 파일이 들어갔다.
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "test.jpg", fileBody);
            ApiInterface apiInterface = Service.getApiClient().create(ApiInterface.class);

            AndMemberVO vo = new AndMemberVO();
            vo.setName("임세진");
            HashMap<String, RequestBody>map = new HashMap<>();
            map.put("vo", RequestBody.create(MediaType.parse("multipart/form-data"), new Gson().toJson(vo)));

           // ApiInterface apiInterface = Service.getApiClient().create(ApiInterface.class);
            apiInterface.sendFiles("file.f", map, filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });

        }
    }

    //모든 사진 파일을 가져와서 => 여러 파일 선택이나 커스텀 갤러리를 만드는 것도 가능.
    public String getRealPath(Uri contentUri){
        //Cursor ==DB== 안드로이드 모든 데이터가 ContentResolver라는 개념으로 DB처럼 접근이 가능.
        //content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F31/ORIGINAL/NONE/image%2Fjpeg/1571713109
        String res= null;
        String [] project = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, project, null, null, null);
        if(cursor.moveToFirst()){
            int column_index  = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res=cursor.getString(column_index);
        }

        return res;
    }

    //checkDangerousPermossion = > 카메라나 위치정보 또는 저장소에 접근하는 경우 사용자의 동의를 받아야람.
    //해당하는 것은 Manifest에 명시해놓고나서 Manifest.permossion.권한이름
    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE

        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("TAG", "권한 승인 됨: " + permissions[i]);
                } else {
                    Log.d("TAG", "권한 승인 안됨: " + permissions[i]);
                }
            }
        }
    }
}