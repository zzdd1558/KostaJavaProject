package com.team.main;

import java.util.Scanner;

import com.team.cart.CartInfoService;
import com.team.mypage.MemberInfoService;
import com.team.util.Service;

public class MainInfoService implements Service {

	Service service = null;
	@Override
	
	public void exec(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.println("1.제품검색\n" + "2.주문상세내역\n" + "3.마이페이지");
		int key = scan.nextInt();
		
		//search 페이지 호출.
		switch (key) {
		case 1:
			
			break;
			
		//cart 페이지 호출
		case 2:
		service = new CartInfoService();
		service.exec(scan);
			break;
		
		
		//mypage 호출
		case 3:
		service = new MemberInfoService();
		service.exec(scan);
			break;

		}
	}
}