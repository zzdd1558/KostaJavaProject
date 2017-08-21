package com.team.order;

import java.util.Scanner;

import com.team.dto.OrdersDTO;

public class Order {
	// order page
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 아이디 
		OrdersDTO odto = new OrdersDTO();
		System.out.println(odto.getId());
		
		// 배송받을 주소 입력
		System.out.println("주소 입력");
		odto.setAddr(sc.next());

		// 수취인 이름
		System.out.println("수취인 이름 입력");
		odto.setName(sc.next());
		
		// 수취인 연락처
		System.out.println("수취인 연락처 입력");
		odto.setPhone(sc.next());
		
		
		
		
		
		
		
		
		
	}

}
