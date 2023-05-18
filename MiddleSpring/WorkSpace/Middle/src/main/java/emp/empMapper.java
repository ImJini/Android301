package emp;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface empMapper {
	public ArrayList<EmpDTO> selectList();
	
	public EmpDTO select(int empNo);

	//사원을 등록한다.
	
	public void setName(String name);
	
	public void setSawon(EmpDTO dto);
	//emp dto에 있으니까 그것만/
	//사원에 대한걸 다 넣어줘야 함. 값만들어있는것.
	//데이터는 데이터베이스에 dto를 넣을 것.
	//쿼리문은 xml에 
	//매개변수 리턴타입을 정해보자 (인터페이스)
	//인터페이스는 하나
	//그거에 하나씩 주석을 달아서 기능을 줄수있게 틀을 만들어보기?
	//메소드는 여러개니까. 각각 달아주기.
	
}
