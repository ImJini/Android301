package com.and.middle;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RestController
public class AndController {

	@RequestMapping(value = "and1.req", produces = "text/html;charset=utf-8")
	public String andReq1() {
		System.out.println("호출되었다.");
		return "";
	}

	// param을 가지고 and 에서는 and2.req를 요청하고 있다.
	// android에서 보내준 파라미터를 출력하고 호출되었다. <=출력되게끔 처리해보기.
	@RequestMapping(value = "and2.req", produces = "text/html;charset=utf-8")
	public String andReq2(String andParam) {
		System.out.println("호출되었다." + andParam);
		return "abcd";
	}
//-----------------------------------------------------------------------------
	
	@RequestMapping(value = "and1.res", produces = "text/html;charset=utf-8")
	public String andRes1() {
		// System.out.println("호출되었다."+andParam);
		return "SpringJIN123";
	}

	@RequestMapping(value = "and2.res", produces = "text/html;charset=utf-8")
	public String andRes2(String andParams) {
		String date = "23-05-10";
		System.out.println("이니셜 받음." + andParams + date);
		String and = (andParams + date);
		return and;
	}

	@RequestMapping(value = "and3.res", produces = "text/html;charset=utf-8")
	public String andRes3(String paramMap) {
		System.out.println(paramMap);
		
		HashMap<String, String>map
		= new Gson().fromJson(paramMap, new TypeToken<HashMap<String, String>>(){}.getType());
		System.out.println(map.get("p1"));
		int index=1;
		for(String key : map.keySet()) {
			map.put(key, map.get(key)+index);
			index++;
		}
		//java 1.8이상 사용가능한 기능 방법을 알고 쓰면 좋음( 낮은 버전에서 일 할수도있으니)
		map.forEach((key, value)->{
			System.out.println(key+value);
		});
		return new Gson().toJson(map);
		
	//public String andRes3(HttpServletRequest req) {
		// public String andRes3(String p1, String p5) {
//		int index = 1;
//		for (char i = 'a'; i <= 'z'; i++) {
//			System.out.println(req.getParameter("p" + index));
//			index++;
//}
//		int cnt = Integer.parseInt(req.getParameter("cnt"));
//		for(int i = 1; i<=cnt; i++) {
//			System.out.println(req.getParameter("p"+i));
//		}
//		//attribute (타입있음) 캐스팅해야함(오브젝트)
//		//prameter(String 고정) 
//		return "";
			
	}

}
