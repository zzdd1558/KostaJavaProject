package com.team.test;

import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.join.LoginService;
import com.team.mypage.MemberInfoService;
import com.team.order.OrdersInfoService;
import com.team.util.Service;

/** Test를 위한 클래스 */

public class Test {

	// userId : 사용자 ID를 저장하기위 해 임시방편으로 만들어둠
	public static String userId = "aaa";

	public static void main(String[] args) {
		MemberTest();

		Scanner scan = new Scanner(System.in);
		boolean check = true;
		Service service = null;
		while (check) {
			// c
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");

			// y
			System.out.println("3. 부품검색");

			// d
			System.out.println("4. 상세주문내역");
			System.out.println("5. 검색 or 마이페이지 or 주문");

			// j
			System.out.println("6. 주문");
			System.out.println("7. 마이페이지");
			System.out.println("8. 로그아웃 ");
			System.out.println("--------------------------------");
			System.out.print(" 선택 : ");

			switch (scan.nextInt()) {

			// 1, 2 창욱
			case 1:

				break;
			case 2:

				break;

			// 3 윤진
			case 3:

				break;

			// 4,5 대호
			case 4:

				break;
			case 5:

				break;

			// 6,7 정규
			case 6:
				service = new OrdersInfoService();
				service.exec(scan);
				break;
			case 7:
				service = new MemberInfoService();
				service.exec(scan);
				break;

			case 8:
				System.out.println("로그아웃 되었습니다");
				check = false;
				break;

			default:
				System.out.println();
				System.out.println("잘못된 숫자를 입력하셨습니다 숫자를 다시입력해주세요");
				System.out.println();
				break;
			} // end of switch
		} // end of while
	} // end of main

	public static void MemberTest() {

		Scanner sc = new Scanner(System.in);

		MemberDao.deleteAll();

		MemberDao.add(new MemberDTO("scott", "tiger", "스캇", "90000", "scott.com", "서울", "01022445555"));
		MemberDao.add(new MemberDTO("tiger", "scott", "타이거", "102010", "tiger.com", "서울", "01033995030"));
		MemberDao.add(new MemberDTO("changuk", "test", "창욱", "120002", "changuk.com", "울산", "0103910395"));
		MemberDao.add(new MemberDTO("test", "1234", "테스트", "903020", "test.com", "부산", "01022224242"));

		new LoginService().exec(sc);
	}// end of MemberTest

}// end of Test
