package com.example.and16_lastproject.common;

import com.example.and16_lastproject.member.AndMemberVO;

public class CommonVal {
    //null이면 로그인이 안되어 있는상태
    //LoginInfo를 나중에 로그인시에는 내용을 채워서 null이 아니게 만듦

    //한번 로그인하고 외부에서는 앱을 종료를 별도로 안하면 로그아웃을 시킬수가 없음.
    //
    public static AndMemberVO loginInfo = null;

}
