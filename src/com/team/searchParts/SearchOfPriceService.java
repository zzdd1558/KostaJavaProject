package com.team.searchParts;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.team.cart.CartInfoService;
import com.team.dao.ItemDao;
import com.team.dto.ItemDTO;
import com.team.util.Service;

public class SearchOfPriceService implements Service {

	@Override
	public void exec(Scanner scan, String id, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		ItemDao itemDao = new ItemDao();
		boolean check = true;
		List<ItemDTO> list = null;
		while (check) {

			System.out.println(" --------------- 부품 종류 ---------------");
			System.out.println("1. 가격으로 찾기");
			System.out.println("2. 코드번호로 부품 구매");
			System.out.println("3. 뒤로가기");
			System.out.println(" ----------------------------------------- ");
			System.out.print(" 입력 : ");
			int select = scan.nextInt();
			scan.nextLine();
			switch (select) {

			case 1:
				System.out.print("최저가 입력 : ");
				int minPrice = scan.nextInt();
				System.out.print("최고가 입력 : ");
				int maxPrice = scan.nextInt();
				scan.nextLine();
				list = itemDao.partsMinAndMaxPrice(minPrice , maxPrice);
				
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());
				}
				break;

			case 2:
				System.out.print("구매할 부품의 부품번호 : ");
				int partsCodeNum = scan.nextInt();
				System.out.print("구매할 부품의 갯수 : ");
				int partsNum = scan.nextInt();
				map.put(partsCodeNum, partsNum);

				System.out.println("1. 주문하기       2. 계속 쇼핑하기");
				int secondSelect = scan.nextInt();
				if (secondSelect == 1) {
					Service service = new CartInfoService();
					service.exec(scan, id, map);
				}

				break;

			case 3:
				check = false;
				break;

			default:
				System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
				break;
			}

		}
	}
}
