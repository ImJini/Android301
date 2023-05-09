package com.and.middle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
	//home이라는 글자가 홈페이지(body)에 바로 써지게 하려면 어떻게 해야할까?
	//답: @ResponseBody를 써주고 return에 쓰기?
	//중요한건 jsp 페이지가 아니라 데이터일때?

	@ResponseBody //응답을 바디에 하겠다.
	@RequestMapping("/")
	public String home() {
	
		
		return "home";
	}
	
}
