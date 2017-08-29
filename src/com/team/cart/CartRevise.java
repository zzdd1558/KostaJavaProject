package com.team.cart;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import com.team.dao.ItemDao;
import com.team.searchParts.SearchPartsService;
import com.team.util.Service;

public class CartRevise implements Service {
	
	@Override
	public void exec(Scanner scan, String id, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		
		boolean check = true;
		
		while(check) {	
			// 장바구니 담은 내역 보여주기
			Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
			
			int num = 1;
			while(it.hasNext()) {
				Entry<Integer, Integer> entry = it.next();
				int k = entry.getKey();			
				System.out.println(num+". " + ItemDao.getItemByNum(k).toString() + "수량 : " + entry.getValue());
				num++;
			}
			
			System.out.println("1.장바구니 삭제\n" + "2.수량변경\n" + "3.구매하러가기 \n" + "4.뒤로가기");
			
			int key = scan.nextInt();
			scan.nextLine();
			
			switch (key) {
			case 1:
				System.out.print("수정할 부품 번호를 선택하세요");
				int removeNum = scan.nextInt();
				
				map.remove(removeNum);		
				
				break;
				
			case 2:
				System.out.print("변경할 부품 번호를 선택하세요");
				int selNum = scan.nextInt();
				System.out.print("수량을 입력하세요");
				int changeNum = scan.nextInt();
				
				map.replace(selNum, changeNum);
				break;
				
			case 3:			
				new SearchPartsService().exec(scan, id, map);
				check = false;
				break;
				
			case 4:
				check = false;
				break;
	
			default:
				System.out.println("잘못된 숫자를 입력하셨습니다 .\n다시입력해 주세요");
				
				break;
			}
			System.out.println();
		}
	}
}
