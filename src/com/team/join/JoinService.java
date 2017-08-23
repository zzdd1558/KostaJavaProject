package com.team.join;

import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.util.Service;

/** 회원 가입 관련 클래스 */
public class JoinService implements Service {

	@Override
	public void exec(Scanner scan,String id) {

		MemberDTO m = new MemberDTO();
		
		System.out.print("아이디: ");
		m.setId(scan.nextLine());
		
		//중복 아이디가 있는지 체크
		if(MemberDao.checkId(m.getId())) {
			System.out.println("아이디가 중복됩니다.");
			return;
		}
		
		System.out.print("비밀번호: ");
		m.setPwd(scan.nextLine());
		
		System.out.print("이름: ");
		m.setName(scan.nextLine());
		
		System.out.print("생일: ");
		m.setBirth(scan.nextLine());
		
		System.out.print("이메일: ");
		m.setMail(scan.nextLine());
		
		System.out.print("주소: ");
		m.setAddr(scan.nextLine());
		
		System.out.print("전화번호: ");
		m.setPhone(scan.nextLine());
		
		if(MemberDao.add(m) != 0)
			System.out.println("회원 가입에 성공하셨습니다.");
		else
			System.out.println("회원 가입에 실패했습니다.");
		
	}//end of exec

}//end of Join
