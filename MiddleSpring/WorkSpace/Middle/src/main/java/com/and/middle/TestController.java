package com.and.middle;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.and.andmember.AndMemberDAO;
import com.and.andmember.AndMemberVO;
import com.google.gson.Gson;

@RestController // 모든 응답에 대해서 ResponseBody가 붙은것처럼 동작함 : Rest Api

public class TestController {
	@Autowired
	@Qualifier("hanul")
	SqlSession sql;
	@Autowired
	AndMemberDAO dao;

	@RequestMapping("test.db")
	public String test() {
		int result = sql.selectOne("test.testint");
		System.out.println(result);
		return "test";
	}
	
	@RequestMapping(value = "test.all", produces = "text/html;charset=utf-8")
	public String list(String and) {
		System.out.println(and);

		// AndmemberDAO dao = new AndMemberDAO(); 은 의존성 자동주입이 안됨 @Autowired
		// @Qualifier("hanul") <- null임

		ArrayList<AndMemberVO> list = new ArrayList<>(dao.AndMemberVO());
		//AndMemberVO vo = new AndMemberVO();
		System.out.println(list);
		// vo.setId("id");
		return new Gson().toJson(list);
	}
	
	@RequestMapping("login.and")
	@GetMapping("/login")
	public String login(String id, String pw) {		
		System.out.println(id+pw);
		//db에 조회조건에 id pw사용해서 조회했을때 데이터 건수의 여부 
		AndMemberVO vo = dao.selectOne(id, pw);
		
		return new Gson().toJson(vo);
	}

	// 패키지 andmember를 만들고 내부에 andmemberVO와 andmemberDAO를 만든다.
	// DAO를 이용해서 andmember 테이블에 있는 전체 정보를 가지고와서 콘솔창에 출력하기.

	// Spring Context를 통해서 Bean객체로 데이터 접속을 만들지 않은경우 , 직접 자바코드로 접속정보를 넣고 사용했다.

//	
//	//Spring conn.xml을 이용 x, java코드로 마이바티스를 이용한 경우였음. ↓
//	public void testMethod() throws IOException {
//		BasicDataSource dbcp= new BasicDataSource();
//		SqlSessionFactoryBean factory= new SqlSessionFactoryBean();
//		factory.setDataSource(dbcp);
//		SqlSessionTemplate sqlsession = new SqlSessionTemplate(factory))
//		
//		//BasicDataSource<= 빈객체로 접속 정보를 만든다. DBCP( Connection Pool)
//		//SqlSessionFactoryBean <= 데이터베이스 접속정보와 맵퍼 위츠를 통해서 SqlSessionFactory를 스프링 객체로 만든다(Bean)
//		//SqlSessionTemplate <= Sqlseeeion을 xml로 만들어내고 java코드에서는 @Autowired @Qualifier를 통해 주입시킴.
//		String resource = "dbconn/conn.xml";
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//			int result = session.selectOne("test.testint");
//			System.out.println(result);
//		}
//	}
//
}
