package com.and.middle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import Member.AndMemberDAO;
import Member.AndMemberVO;

@RestController
public class MemberController {

	// MemberController에 접근하는 매핑규칙을 .mem<=

	@Autowired
	AndMemberDAO dao;

	@RequestMapping(value = "login.mem", produces = "text/html;charset=UTF-8")
	public String andReq1(String id, String pw) {
		System.out.println(id + "" + pw);
		System.out.println("호출되었다.");
		// dao.testInt();
		// login메소드 호출하기.
		AndMemberVO vo = new AndMemberVO();//
		vo.setId(id);
		vo.setPassword(pw);
		//dao.login(vo);
		return new Gson().toJson(dao.login(vo));
		// return "호출완료";
	}

}
