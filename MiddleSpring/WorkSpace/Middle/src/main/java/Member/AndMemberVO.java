package Member;

import lombok.Data;

@Data
public class AndMemberVO {
	
//	//vo로 작업을 할때는  생성자를 안만드는게 원칙임.
//
//내부의 getter와 setter를 통해서 마이바티스가 데이터를 채워주는 기능을 수행. 
//
//==생성자를 만들면 오류가 발생.
//
//만들거면 비어있는 객체를 만들어줘야 됨. 
//
//vo만들때 별도로 이름을 맞추는게 아닌 경우에는 데이터베이스 컬럼 이름을 소문자로하여 똑같이 만든다.
	
	
	private String id, password, name, phonenumber, adress;


}
