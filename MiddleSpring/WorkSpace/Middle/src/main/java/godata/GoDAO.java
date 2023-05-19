package godata;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GoDAO {
	@Autowired
	@Qualifier("hanul")
	SqlSession sql;

	public void insertGo(ArrayList<GoDTO> list) {
		// for (sql.insert(null)) 통신을 열고 닫는 빈도가 너무 많음.
		int result = sql.insert("godata.insertall", list);
		System.out.println(result);

	}

	public List<GoDTO> selectMap() {
		List<GoDTO> list = sql.selectList("godata.selectmap");
		return list;

	}

}
