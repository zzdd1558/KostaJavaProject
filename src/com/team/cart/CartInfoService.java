package com.team.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.team.dao.ItemDao;
import com.team.dto.ItemDTO;
import com.team.order.OrdersInfoService;
import com.team.util.Service;

public class CartInfoService implements Service {
	
	Service service = null;
	@Override
	public void exec(Scanner scan,String id , Map<Integer,Integer> map) {
		// TODO Auto-generated method stub
		
		// Search(구매하려고 담은 목록) 보여주기
		
		List<ItemDTO> list = null;
		List<Integer> count = null;
		boolean check = true;
		
<<<<<<< HEAD
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 장바구니에 담아놓은 목록 주문하기, 수정하기
		System.out.println("1.주문하기\n2.장바구니수정하기");
		
		int key = scan.nextInt();
		
		switch (key) {
		case 1:    
			service = new OrdersInfoService();
			service.exec(scan, id, map);
			break;
=======
		while(check) {
			list = new ArrayList<>();
			count = new ArrayList<>();
			for(int n : map.keySet()) {		
				list.add(ItemDao.getItemByNum(n));
				count.add(map.get(n));
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
				System.out.println(" 수량 : " + count.get(i));
			}
>>>>>>> branch 'master' of https://github.com/zzdd1558/KostaJavaProject.git
			
			
			// 장바구니에 담아놓은 목록 주문하기, 수정하기
			System.out.println("1.주문하기\n" + "2.장바구니수정하기\n" + "3.뒤로가기");
			
			int key = scan.nextInt();

			
			switch (key) {
			case 1:    
				service = new OrdersInfoService();
				service.exec(scan, id, map);
				break;
				
			case 2:
				service = new CartRevise();
				service.exec(scan, id, map);
				break;
				
			case 3:
				check = false;
				break;
				
			default:
				System.out.println("잘못된 번호를 입력하셨습니다");
				break;
			}
			System.out.println();
		}
	}
}
	
