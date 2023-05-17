package Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class AndMemberDAO {
	@Autowired @Qualifier("hanul") SqlSession sql; //의존성 자동주입을 사용하는 곳은 Spring 객체여야함. ==스프링 객체로 만들어줌.
	
	//test-mapper에서 dual테이블을 이용하여 내가 원하는 숫자를 조회해오는지 테스트해보기.
	
	public void testInt() {
	 int result = sql.selectOne("test.testint");//namespace.id
	 System.out.println("DB접속: "+result);
	 
	}
	
	public AndMemberVO login(AndMemberVO paramVo) {
		//sql-mapper이용해서 입력된 아이디와 패스워드가 일치하는 회원이 존재하는지 여부를 조회한다. (결과가 있다면 DTO를 Android에 전송)
		AndMemberVO vo = sql.selectOne("member.login", paramVo);//namespace.id
		//System.out.println(vo.getName());
		return vo;
	}	
}
