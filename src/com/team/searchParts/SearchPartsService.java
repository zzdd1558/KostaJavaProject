package com.team.searchParts;

import java.util.Scanner;

import com.team.util.Service;

public class SearchPartsService implements Service {

	@Override
	public void exec(Scanner scan) {
		// TODO Auto-generated method stub
		Service service = null;
		System.out.println("1. 가격으로 검색 ");
		System.out.println("2. 제조사별 검색 ");
		System.out.println("3. 제품이름으로 검색 ");
		System.out.println("--------------------");
		System.out.print("선택 : ");
		int select = scan.nextInt();
		scan.nextLine();

		switch (select) {
		case 1:
			service = new SearchOfPriceService();
			service.exec(scan);
			break;
		case 2:
			service = new SearchOfCompanyService();
			service.exec(scan);
			break;
		case 3:
			service = new SearchOfNameService();
			service.exec(scan);
			break;

		default:
			break;
		}

	}

}
