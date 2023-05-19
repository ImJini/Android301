package com.and.middle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import godata.GoDAO;
import godata.GoDTO;

@RestController
public class GodataController {
	@Autowired
	GoDAO dao;

	@RequestMapping(value = "list.go", produces = "text/html;charset=UTF-8")
	public String goList(String tempList) {
		// Android에서 정리 된 데이터를 받아서 이제 데이터 타입이 있는goDTO만들예정
		ArrayList<GoDTO> list = new Gson().fromJson(tempList, new TypeToken<ArrayList<GoDTO>>() {
		}.getType());
		System.out.println(list.size());
		System.out.println(tempList);
		//dao.insertGo(list);
		return new Gson().toJson("");
	}

//	  ArrayList<GoDTO> list = new Gson().fromJson(data,
//              new TypeToken<ArrayList<GoDTO>>(){}.getType());

	@RequestMapping(value = "map.go", produces = "text/html;charset=UTF-8")
	public String mapList() {
		// Android에서 정리 된 데이터를 받아서 이제 데이터 타입이 있는goDTO만들예정
		List<GoDTO>list = dao.selectMap();
		return new Gson().toJson(list);
	}

}
