package com.team.join;

import java.util.Map;
import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.main.MainInfoService;
import com.team.util.Service;

/** 로그인 기능을 제공하는 클래스 */
public class LoginService implements Service {

	@Override
	public void exec(Scanner scan,String ad , Map<Integer,Integer> map) {

		//아이디 비밀번호 입력받기
		System.out.print("아이디를 입력하세요.");
		String id = scan.nextLine();
		
		System.out.print("비밀번호를 입력하세요.");
		String pwd = scan.nextLine();
		
		//아이디 패스워드와 일치하는 객체 찾아오기
		MemberDTO m = MemberDao.checkMember(id,pwd);
		
		if(m == null) 
			System.out.println("로그인에 실패했습니다.");
		else {
			System.out.println("로그인에 성공했습니다.");
			new MainInfoService().exec(scan, id , map);;
		}
		
	}//end of exec

}//end of LoginService
