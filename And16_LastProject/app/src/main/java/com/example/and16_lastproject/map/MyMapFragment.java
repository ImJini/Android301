package com.example.and16_lastproject.map;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and16_lastproject.R;
import com.example.and16_lastproject.conn.CommonConn;
import com.example.and16_lastproject.databinding.FragmentGoBinding;
import com.example.and16_lastproject.databinding.FragmentMyMapBinding;
import com.example.and16_lastproject.emp.EmpDTO;
import com.example.and16_lastproject.godata.GoDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

//name : And16LastProject
//ClientID: 8rmrboqjkb
//Client Secret EsoMqmy97Q0pYZSe7hfvEYpdNnCC5POk5w31jhKF
public class MyMapFragment extends Fragment implements OnMapReadyCallback {


   FragmentGoBinding binding;
   NaverMap naverMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentGoBinding.inflate(getLayoutInflater(),container,false);

        NaverMapSdk.getInstance(getContext()).setClient(
                new NaverMapSdk.NaverCloudPlatformClient("8rmrboqjkb"));

        binding.mapView.getMapAsync(this);


        return binding.getRoot();

    }



    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap= naverMap;
        naverMap.setMapType(NaverMap.MapType.Hybrid); //맵 타입이 바뀐다고 함.
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(35.1502395, 126.857215));
        naverMap.moveCamera(cameraUpdate);

        Marker marker = new Marker();
        marker.setPosition(new LatLng(35.1502395, 126.857215));
        marker.setMap(naverMap);

        ArrayList<TempDTO>list= new ArrayList<>();

        CommonConn conn =new CommonConn(getContext(), "map.go");
        conn.onExcute((isResult, data) -> {
            ArrayList<GoDTO> map = new Gson().fromJson(data,
                    new TypeToken<ArrayList<GoDTO>>(){}.getType());
            Log.d("지도", "onMapReady: "+data);

        for (int i = 0; i < map.size(); i++) {
            Marker maker = new Marker();
            maker.setPosition(new LatLng(map.get(i).getLat(), map.get(i).getLng()));
            maker.setSubCaptionText(map.get(i).getLocalSpecialStNm());
            maker.setMap(naverMap);
        }


        });


//        this.naverMap.op
//        NaverMapOptions options = new NaverMapOptions()
//                .camera(new CameraPosition(new LatLng(35.1798159, 129.0750222), 8))
//                .mapType(NaverMap.MapType.Terrain);



    }

    @Data
    public class TempDTO{
        public TempDTO(double lat, double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        double lat, lng;
    }
}