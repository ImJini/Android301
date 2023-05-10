package com.and.andmember;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AndMemberDAO {

	// 데이터 베이스에 접근하여, 데이터를 조회해오고 그 결과를 컨트롤러나 필요한 곳에 리턴해준다.

	// 1. 처음 서버가 시작 시 root-context가 스캔과 import를 통해서 bean 객체를 만들어 낸다.(
	// dbconn/default.xml을 열어서 보고 전부다 묶어서 의존성 주입을 해줌.)
	// 2. Autowired를 통해서 빈객체가 생성될때 필요한 것들은 전부 역으로 가지고와서 자동으로 객체가 null이 아닌 필요한 정보를
	// 담고있는 객체로 생성되게 한다.
	// -Spring은 Spring 객체끼리 의존성 주입이 된다.(↑)
	// 3. mapper를 통해서 sql문을 실행하여 그 결과를 가지고 옴(java)

	@Autowired
	@Qualifier("hanul")
	SqlSession sql; // 이것만 쓰면 null이니까 @Repository 달아주기

	public List<AndMemberVO> AndMemberVO() {
		// public List<AndMemberVO>

		return sql.selectList("test.testall");

	}

	public AndMemberVO selectOne(String id, String pw) {
		// mapper 맨위에 있는 namespace
		// .mapper 자식요소의 select 등등의 태그 id
		// namespace.id==statment(쿼리)
		// sql.selectOne(id, pw);

		AndMemberVO vo = new AndMemberVO();
		vo.setId(id);
		vo.setPassword(pw);

		// vo가 준비가 안되어있다면 hashmap을 쓰면 좋다.
//	HashMap<String, String> map = new HashMap<String, String>();
//	map.put(id, id);
//	map.put(pw, pw);

		vo = sql.selectOne("test.login", vo);
		if (vo != null) {

			System.out.println(vo.getName());
		} else {
			System.out.println("회원 아님.");
		}
		return vo;
	}

	public void test(String param) {
		// mybatis mapper는 우리가 파라미터를 보내줘야하는 경우가 있음(데이터의 신규추가, 수정, 삭제, 조회조건 등)
		String returnDB = sql.selectOne("param.test1", param);// 메퍼에 있는 네임스페이스에 내가 원하는 걸 쓴것 . 파라미터는 한개만 받아올건데
		// 만약 여러건을 가져오고 싶으면 ?
		System.out.println(returnDB);
	}

	public void multiTest(String param1, String param2, String param3) {
		// System.out.println("url을 통해서 param1~3을 multiTest메소드로 가져와서 출력
		// "+param1+param2+param3);
		// ArrayList, Array, HashMap..을 써서 여러개의 값을 받아올수있음.
		HashMap<String, String> params = new HashMap<>();
		params.put("p1", param1);
		params.put("p2", param2);
		params.put("p3", param3);
		String returnDB = sql.selectOne("param.test2", params);
		System.out.println(returnDB);
		// 묶어서 전송을 해야됨.

	}

	public void multiRow(String p1, String p2, String p3) {
		// 파라미터 3개를 받아서 SelectList를 작업해보기.
		// 힌트 쿼리날려서 나오는데 그걸 집합이라고 함. AuBuC 집합집합.
		HashMap<String, String> params = new HashMap<>();

		params.put("p1", p1);
		params.put("p2", p2);
		params.put("p3", p3);
		List<String> returnDBList = sql.selectList("param.test3", params);
		for (String param : returnDBList) {
			System.out.println(param);
		}

	}

	public void selectRowOne() {
		ParamVO vo = sql.selectOne("param.selectRowOne");
		System.out.println(vo.getCol1());
	}

	public void selectRowMulti() {
		List<ParamVO> list = sql.selectList("param.selectRowMulti");
		System.out.println(list.size());
	}

	
	public void selectRdOne() {
		RandomVO rd = sql.selectOne("param.selectRdOne");
		System.out.println(rd.getMenu1());
	}

}
