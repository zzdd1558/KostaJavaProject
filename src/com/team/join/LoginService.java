package com.team.join;

import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.util.Service;

/** 로그인 기능을 제공하는 클래스 */
public class LoginService implements Service {

	/** 로그인을 실행하는 함수 */
	public String login(Scanner scan) {

		//아이디 비밀번호 입력받기
		System.out.print("아이디를 입력하세요.");
		String id = scan.nextLine();
		
		System.out.print("비밀번호를 입력하세요.");
		String pwd = scan.nextLine();
		
		//아이디 패스워드와 일치하는 객체 찾아오기
		MemberDTO m = MemberDao.checkMember(id,pwd);
		
		if(m == null) {
			System.out.println("로그인에 실패했습니다.");
			return null;
		}
		else {
			System.out.println("로그인에 성공했습니다.");
			return id;
		}
		
	}//end of exec
	
	@Override
	public void exec(Scanner scan) {

	}//end of exec

}//end of LoginService
