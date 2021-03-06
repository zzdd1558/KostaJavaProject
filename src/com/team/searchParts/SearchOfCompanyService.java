package com.team.searchParts;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.team.cart.CartInfoService;
import com.team.dao.ItemDao;
import com.team.dto.ItemDTO;
import com.team.util.Service;

public class SearchOfCompanyService implements Service {

	@Override
	public void exec(Scanner scan, String id , Map<Integer,Integer> map) {
		// TODO Auto-generated method stub
		ItemDao itemDao = new ItemDao();
		List<ItemDTO> list = null;
		boolean check = true;
		while (check) {
			System.out.println(" ----------------------------------------- ");
			System.out.println("1. 제조사의 종류 확인하기");
			System.out.println("2. 제조사 이름으로 바로 검색");
			System.out.println("3. 뒤로가기");
			System.out.println(" ----------------------------------------- ");
			System.out.print(" 입력 : ");
			int select = scan.nextInt();
			scan.nextLine();
			switch (select) {
			case 1:
				System.out.println(" --------------- 제조사 목록 ---------------");
				list = itemDao.partsCompanyConfirm();
				for (int i = 0; i < list.size(); i++) {
					System.out.printf("[제조사] : %10s [부품명] : %10s\n" , list.get(i).getCompany() , list.get(i).getListName());
				}

				break;
			case 2:
				System.out.print("제조사의 이름 입력 : ");
				String company = scan.nextLine();
				list = itemDao.searchForPartsByCompany(company);
				
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).toString());
				}
				System.out.print("구매할 부품의 부품번호 : ");
				int partsCodeNum = scan.nextInt();
				System.out.print("구매할 부품의 갯수 : ");
				int partsNum = scan.nextInt();
				map.put(partsCodeNum, partsNum);
				
				System.out.println("1. 주문하기       2. 계속 쇼핑하기");
				int secondSelect = scan.nextInt();
				scan.nextLine();
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

		} // end of while
	} // end of exec

}
