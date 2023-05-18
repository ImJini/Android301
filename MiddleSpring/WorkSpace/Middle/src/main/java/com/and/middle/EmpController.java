package com.and.middle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import emp.EmpDAO;

@RestController
public class EmpController {

	@Autowired
	EmpDAO dao;

	@RequestMapping(value = "select.emp", produces = "text/html;charset=UTF-8")
	public String selectList(String query) {

		// 1. select.emp까지 접근이 가능한지 크롬을 이용해서 테스트 해보기 ㅇㅇ
		// 2. package -> emp 추가하기 (root-context에서 component 해줘야 함.
		// No qualifying bean of 이거 뜨니까
		// 3. empDTO와 empDAO 추가하기
		// 4. empDAO에서 우리가 sql 에서 조회했던 내용을 조회해오기 만들기
		// 5. 크롬창에 조회된 결과 보여주기===========================
		// 6. 안드에서 받아오기.

		// DB(Query) = > mapper = > mapper(param) = >Spring(param)controller = >and
		// 1.query를 이용하여 , 이름 또는 부서가 query를 포함하고 있는 결과를 필터링 하기(select쿼리를 통해서)
		// ex> 길동 = > 길동의 이름을 가진 사람과 부서가 길동인 사람의 목록이 쭉 나옴
		// ex) 영업 = > 영업을 포함하고 있는 (이름, 부서) 데이터가 쭉 나옴

		if (query != null && query.trim().length() > 0) {
			return new Gson().toJson(dao.selectList(query));
		}

		return new Gson().toJson(dao.selectList());
	}

}
