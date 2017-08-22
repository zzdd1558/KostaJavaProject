package com.team.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.team.dao.ItemDao;
import com.team.dto.ItemDTO;
import com.team.util.DBUtil;
import com.team.util.Service;

public class CartInfo implements Service {

	@Override
	public void exec(Scanner scan) {
		// TODO Auto-generated method stub
		
		Map<Integer, Integer> map = new HashMap<>();
		List<ItemDTO> list = new ArrayList<>();
		
		for(int n : map.keySet()) {		
			list.add(ItemDao.getItemByNum(n));
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		System.out.println("1.주문하기\n2.수정하기");
		
		int key = scan.nextInt();
		
		switch (key) {
		case 1:
//			orderDao od = new orderDao();
			
			break;
			
		case 2:
			System.out.println("수정할 부품종류를 선택하세요");
			System.out.println("1.Case 2.CPU 3.HDD 4.MainBoard 5.ODD\n" + "6.OperatingSystem 7.power 8.Ram 9.ssd 10.vga");
					
			int i = scan.nextInt();
			
			Map<Integer, String> map1 = new HashMap<>();
			
			String s = null;
			for(ItemDTO id : list) {
				if(id.getItemNum()==i) {
					s = id.getItemName();
				}
			}
			
			map1.put(i, s);
			
			break;
		
		}
	}

}
