package com.team.order;

import java.util.Map;
import java.util.Scanner;

import com.team.cart.CartInfoService;
import com.team.dao.OrdersDao;
import com.team.dto.OrdersDTO;
import com.team.main.MainInfoService;
import com.team.util.Service;

public class OrdersInfoService implements Service {

	@Override
	public void exec(Scanner scan, String id, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		OrdersDTO odto = new OrdersDTO();
		scan.nextLine();
		// ID 받아 오기
		System.out.println(" -----------------------------------------");
		System.out.println("ID : " + id);
		System.out.println(" -----------------------------------------");

		boolean check = true;
		while (check) {

			System.out.println(" --------------- 주문 하기 ---------------");
			System.out.println("1. 주문정보 입력하기");
			System.out.println("2. 뒤로가기");
			System.out.println(" ----------------------------------------- ");
			System.out.print(" 입력 : ");
			int select = scan.nextInt();
			scan.nextLine();
			switch (select) {
			case 1:
				// 배송지 주소 입력
				System.out.print("배송지 주소 입력 : ");
				odto.setAddr(scan.nextLine());

				// 수취인 이름
				System.out.print("수취인 이름 입력 : ");
				odto.setName(scan.nextLine());

				// 수취인 연락처
				System.out.print("수취인 연락처 입력 : ");
				odto.setPhone(scan.nextLine());

				odto.setId(id);

				System.out.println("=============== 주문 정보 확인 ===============");
				System.out.println("주문자의 아이디 : " + id);
				System.out.println("배송지 주소 : " + odto.getAddr());
				System.out.println("수취인 이름 : " + odto.getName());
				System.out.println("수취인 연락처 : " + odto.getPhone());
				System.out.println("==============================================");
				System.out.println("입력하신 정보가 맞습니까??");
				System.out.println(" 1 . 예\t2 . 아니오");
				int key = scan.nextInt();
						
				switch (key) {
				case 1:
					if (OrdersDao.add(odto) != 0) {
						System.out.println("주문 성공!");
						check = false;
						new MainInfoService().exec(scan, id, map);
					} else {
						System.out.println("주문 실패!");
						continue;
					}
					break;

				case 2:
					System.out.println("다시 입력해 주세요.");
					break;

				default:
					System.out.println("잘못된 숫자를 입력하셨습니다.");
					break;
				}
				break;
			case 2:
				new CartInfoService().exec(scan, id, map);
				break;

			default:
				System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
				break;
			} // end of switch

		} // end of while

	} // end of exec

	public void billPrint() {

	}

} // end of OrdersInfoService
