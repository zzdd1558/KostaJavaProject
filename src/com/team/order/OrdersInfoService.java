package com.team.order;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.team.dao.OrdersDao;
import com.team.dto.OrdersDTO;
import com.team.util.Service;

public class OrdersInfoService implements Service {

	@Override
	public void exec(Scanner scan,String id) {
		// TODO Auto-generated method stub
		OrdersDTO odto = new OrdersDTO();

		// 주문 번호

		// ID 받아 오기

		// 배송지 주소 입력
		System.out.println("배송지 주소 입력");
		odto.setAddr(scan.nextLine());

		// 수취인 이름
		System.out.println("수취인 이름 입력");
		odto.setName(scan.nextLine());

		// 수취인 연락처
		System.out.println("수취인 연락처 입력");
		odto.setPhone(scan.nextLine());

		// 주문 시간
//		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
		String strDate = dateFormat.format(Calendar.getInstance().getTime());

		odto.setOrderTime(strDate);
		odto.setId(id);
		
		// DAO 클래스의 정보 입력 메소드 호출
		OrdersDao.add(odto);

	}

}
