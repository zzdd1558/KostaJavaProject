package com.team.join;

import java.util.Scanner;

import com.team.dao.AddData;
import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;

public class Login {

	// 프로그램 시작
	public void start() {

		Scanner scan = new Scanner(System.in);
		AddData.initiate();
		MemberDao.add(new MemberDTO("scott","tiger","�뒪罹�","90000","scott.com","�꽌�슱","01022445555"));

		
		while (true) {
			
			System.out.println("기능을 선택하세요");
			System.out.println("(1.로그인 2.회원가입)");
			int num = Integer.parseInt(scan.nextLine());

			switch (num) {
			case 1:
				new LoginService().exec(scan,null);
				break;
			case 2:
				new JoinService().exec(scan,null);
				break;
			default:
				System.out.println("잘못된 선택입니다.");
				break;
			}
		}

	}// end of start

}// end of Login
