package com.team.searchParts;

import java.util.List;
import java.util.Scanner;

import com.team.dao.ItemDao;
import com.team.dto.ItemDTO;
import com.team.util.Service;

public class SearchOfCompanyService implements Service {

	@Override
	public void exec(Scanner scan, String id) {
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
