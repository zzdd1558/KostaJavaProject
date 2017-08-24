package com.team.mypage;

import java.util.Map;
import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.main.MainInfoService;
import com.team.util.Service;

public class MemberInfoService implements Service {

	@Override
	public void exec(Scanner scan, String id , Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		// 기존 회원정보 출력
		MemberDTO member = MemberDao.searchMember(id);

		if (member != null)
			System.out.println(member.toString());
		// member 정보를 찾지 못 했을 시
		else {
			System.out.println("찾을 수 없는 정보 입니다.");
			return;
		}

		// 회원정보 수정

		System.out.println("수정할 정보 선택\n1. 이름\n2. 이메일\n3. 주소\n4. 전화번호");
		int num = Integer.parseInt(scan.nextLine());
		String update = "";
		switch (num) {
		case 1:
			System.out.println("이름 수정");
			update = "name";
			break;
		case 2:
			System.out.println("이메일 수정");
			update = "mail";
			break;
		case 3:
			System.out.println("주소 수정");
			update = "addr";
			break;
		case 4:
			System.out.println("전화번호 수정");
			update = "phone";
			break;
		default:
			break;
		}

		String content = scan.next();

		if (MemberDao.updateMember(id, content, update) != 0)
			System.out.println("성공입니다.");
		else
			System.out.println("실패입니다.");

		new MainInfoService().exec(scan, id , map);

	}

}
