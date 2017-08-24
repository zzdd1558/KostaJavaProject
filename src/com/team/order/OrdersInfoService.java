package com.team.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.team.cart.CartInfoService;
import com.team.dao.OrdersDao;
import com.team.dto.OrdersDTO;
import com.team.util.Service;

public class OrdersInfoService implements Service {

	@Override
	public void exec(Scanner scan, String id) {
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
				System.out.println("수취인 이름 입력 : ");
				odto.setName(scan.nextLine());

				// 수취인 연락처
				System.out.println("수취인 연락처 입력 : ");
				odto.setPhone(scan.nextLine());

				// 주문 시간
				// Date d = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
				String strDate = dateFormat.format(Calendar.getInstance().getTime());

				odto.setOrderTime(strDate);
				odto.setId(id);
				// DAO 클래스의 정보 입력 메소드 호출
				if (OrdersDao.add(odto) != 0)
					System.out.println("주문 성공!");
				else
					System.out.println("주문 실패!");
				break;

			case 2:
				new CartInfoService().exec(scan, id);
				break;

			default:
				System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
				break;
			}

		}


		
	}

}
