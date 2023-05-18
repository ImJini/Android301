package godata;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GoDAO {
	@Autowired @Qualifier("hanul") SqlSession sql;
	
	

}
