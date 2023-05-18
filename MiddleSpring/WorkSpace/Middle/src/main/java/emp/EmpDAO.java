package emp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;

@Service // sql을 xml로해서 스프링으로 쓰겠다 인데. db설정에서 스프링객체로 만들었을때 오토와이어로 받아오려면 그래서 서비스나 레파지토리
			// 쓰는거!
public class EmpDAO {
	@Autowired
	@Qualifier("hanul")
	SqlSession sql;

	public List<EmpDTO> selectList() {
		List<EmpDTO> list = sql.selectList("emp.list");
		return list;
		
	}

	public List<EmpDTO> selectList(String query) {
		List<EmpDTO> list = sql.selectList("emp.list_query", query);
		return list;
	}

}
