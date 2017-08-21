package com.team.mypage;

import java.util.List;
import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.util.Service;

public class MemberInfoService implements Service{

	@Override
	public void exec(Scanner scan) {
		// TODO Auto-generated method stub
		// 기존 회원정보 출력
		MemberDao member = new MemberDao();
		
		List<MemberDTO> list = member.memberList();
		
		for( MemberDTO temp: list) {
			System.out.println(temp);
		}
		
		// 회원정보 수정
		
		System.out.println("수정할 정보 선택\n1. 이름\n2. 이메일\n3. 주소\n4. 전화번호");
		int num = scan.nextInt();
		switch (num) {
		case 1:
			System.out.println("이름 수정");
			String id = scan.next();
//			member.updateName(id, Member.userId);
			
			break;
		case 2:
			System.out.println("이메일 수정");
			String mail = scan.next();
			
			break;
		case 3:
			System.out.println("주소 수정");
			String addr = scan.next();
			break;
		case 4:
			System.out.println("전화번호 수정");
			String phone = scan.next();
			break;

		default:
			break;
		}
		
		
		
		
	}
	
}
