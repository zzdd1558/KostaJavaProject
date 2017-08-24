package com.team.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.team.dao.ItemDao;
import com.team.dto.ItemDTO;
import com.team.order.OrdersInfoService;
import com.team.util.Service;

public class CartInfoService implements Service {
	
	Service service = null;
	@Override
	public void exec(Scanner scan,String id) {
		// TODO Auto-generated method stub
		
		// Search(구매하려고 담은 목록) 보여주기
		Map<Integer, Integer> map = new HashMap<>();
		List<ItemDTO> list = new ArrayList<>();
		
		for(int n : map.keySet()) {		
			list.add(ItemDao.getItemByNum(n));
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// 장바구니에 담아놓은 목록 주문하기, 수정하기
		System.out.println("1.주문하기\n2.장바구니수정하기");
		
		int key = Integer.parseInt(scan.nextLine());
		
		switch (key) {
		case 1:
			service = new OrdersInfoService();
			service.exec(scan, id);
			break;
			
		case 2:
			
		
		}
	}

}
