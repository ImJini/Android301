package com.and.middle;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

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
		// dao.login(vo);
		return new Gson().toJson(dao.login(vo));
		// return "호출완료";
	}

//Form태그 : 태그 사이에 있는 모든 입력 양식을 감싸는 태그로 name, action, method, autocomplate등의
	// 속성을 가지고 있음 (enctype : 폼데이터가 서버로 전송될 때 파일을 담고 있다면 데이터는 인코딩 과정이 필요)
	// enctype : mutipart/form-data (파일을 전송하기 위해서 사용됨)
	@RequestMapping(value = "file.f", produces = "text/html;charset=UTF-8")
	public String file(HttpServletRequest req) {
		System.out.println("여기까지 왔는지");
		System.out.println(req.getParameter("vo"));
		System.out.println(req.getLocalAddr());
		System.out.println(req.getLocalPort());
		System.out.println(req.getContextPath()+"/file");

		MultipartRequest mReq = (MultipartRequest) req;
		// mReq.getFileMap().get("file");
		// MultipartFile f = mReq.getFile("file");
		// 파일이 있는 상태의 요청을 받았는지? => MultipartRequest로 캐스팅
		// 파일이 없는 상태의 요청인지? HttpServletRequest
		// System.out.println(mReq.getFile("file"));
		MultipartFile mFile = mReq.getFile("file");
		try {
			mFile.transferTo(new File("D:\\Study-Android\\MiddleImage\\20230523", "camera.jpg"));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// File f = new File("D:\\study_Android\\MiddleImage\\20230523");
		// if (f.exists()) {
		// f.mkdir();
		// }

		// CommonsMultipartResolver : Resolver (
		// 폼태그나 또는 외부에서 들어오는 데이터가 Mutipart라면 자동으로 인코딩 처리를 하게 만드는 '관리자'

		return null;
	}
}
