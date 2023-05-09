package com.and.andmember;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AndMemberDAO  {
	
	//데이터 베이스에 접근하여, 데이터를 조회해오고 그 결과를 컨트롤러나 필요한 곳에 리턴해준다.
	
	//1. 처음 서버가 시작 시 root-context가 스캔과 import를 통해서 bean 객체를 만들어 낸다.( dbconn/default.xml을 열어서 보고 전부다 묶어서 의존성 주입을 해줌.)
	//2. Autowired를 통해서 빈객체가 생성될때 필요한 것들은 전부 역으로 가지고와서 자동으로 객체가 null이 아닌 필요한 정보를 담고있는 객체로 생성되게 한다.
	// -Spring은 Spring 객체끼리 의존성 주입이 된다.(↑)
	//3. mapper를 통해서 sql문을 실행하여 그 결과를 가지고 옴(java)
	
@Autowired @Qualifier("hanul") SqlSession sql; //이것만 쓰면 null이니까 @Repository 달아주기

public List<AndMemberVO> AndMemberVO() {
	//public List<AndMemberVO> 
	
	return sql.selectList("test.testall");
	
}
public AndMemberVO selectOne(String id, String pw) {
	//mapper 맨위에 있는 namespace 
	//.mapper 자식요소의 select 등등의 태그 id
	//namespace.id==statment(쿼리)
	//sql.selectOne(id, pw);
	
	AndMemberVO vo =new AndMemberVO();
	vo.setId(id);
	vo.setPassword(pw);
	
	//vo가 준비가 안되어있다면 hashmap을 쓰면 좋다.
//	HashMap<String, String> map = new HashMap<String, String>();
//	map.put(id, id);
//	map.put(pw, pw);
	
	vo = sql.selectOne("test.login", vo);
	if (vo != null) {
		
		System.out.println(vo.getName());
	}else {
		System.out.println("회원 아님.");
	}
	return vo;
	
	
}












}
