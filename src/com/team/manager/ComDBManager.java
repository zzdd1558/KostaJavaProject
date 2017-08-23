package com.team.manager;

import java.util.Scanner;

import com.team.cart.CartInfo;

public class ComDBManager {
	
	public void menu() {
		System.out.println("1.제품보기\n" + "2.주문상세내역\n" + "3.마이페이지");
		Scanner scan = new Scanner(System.in);
		int key = scan.nextInt();
		
		switch (key) {
		case 1:
			//search 페이지 호출.
			
			break;
			
		case 2:
		//cart 페이지 호출
		CartInfo ci = new CartInfo();
		ci.exec(scan,null);
		break;
		
		case 3:
			//mypage 호출
			
			break;
			
		}
		
	}
	
}
			
