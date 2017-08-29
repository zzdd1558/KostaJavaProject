package com.team.main;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.team.cart.CartInfoService;
import com.team.join.Login;
import com.team.mypage.MemberInfoService;
import com.team.searchParts.SearchPartsService;
import com.team.util.Service;

public class MainInfoService implements Service {

	Service service = null;

	@Override

	public void exec(Scanner scan, String id, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		boolean check = true;
		while (check) {

			System.out.println("1.제품검색\n" + "2.주문상세내역\n" + "3.마이페이지\n" + "4.로그아웃");
			int key = scan.nextInt();

			// search 페이지 호출.
			switch (key) {
			case 1:
				new SearchPartsService().exec(scan, id, map);
				break;

			// cart 페이지 호출
			case 2:
				new CartInfoService().exec(scan, id, map);
				break;

			// mypage 호출
			case 3:
				new MemberInfoService().exec(scan, id, map);
				break;

			case 4:
				new Login().start();
				break;

			case 5:
				
				Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
				
				while(it.hasNext()){
					Entry<Integer, Integer> temp = it.next();
					System.out.println(temp.getKey() + " : " + temp.getValue());
				}
				break;

			default:
				System.out.println("잘못된 번호를 입력하셨습니다");
				break;

			}
		}
	}
}