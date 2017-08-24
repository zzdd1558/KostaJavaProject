package com.team.searchParts;

import java.util.List;
import java.util.Scanner;

import com.team.dao.ItemDao;
import com.team.dto.ItemDTO;
import com.team.util.Service;

public class SearchOfNameService implements Service {

	/** 이름으로 부품 검색 */
	@Override
	public void exec(Scanner scan, String id) {
		// TODO Auto-generated method stub
		ItemDao itemDao = new ItemDao();
		boolean check = true;
		while (check) {

			System.out.println(" --------------- 부품 종류 ---------------");
			System.out.println("1. 부품의 종류 확인하기");
			System.out.println("2. 이름으로 바로 검색");
			System.out.println("3. 뒤로가기");
			System.out.println(" ----------------------------------------- ");
			System.out.print(" 입력 : ");
			int select = scan.nextInt();
			scan.nextLine();
			switch (select) {
			case 1:
				partsConfirm(scan, itemDao);
				break;
			case 2:
				searchByPartName(scan , itemDao);
				break;
			case 3:
				check = false;
				break;

			default:
				System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해 주세요.");
				break;
			}

		}
	} // end of exec

	/** 부품 이름으로 바로 검색하기 */
	public static void searchByPartName(Scanner scan, ItemDao itemDao) {

		System.out.print("부품 이름을 입력하세요 : ");
		String partsName = scan.nextLine();

		List<ItemDTO> list = itemDao.searchForPartsByName(partsName);
		System.out.println(list.size());
		for (ItemDTO item : list) {
			System.out.println(item.toString());
		}// end of for
	} // end of searchByPartname

	/** 선택 부품 목록 확인하기 */
	public static void partsConfirm(Scanner scan, ItemDao itemDao) {
		String partsName = "";
		System.out.println(" ---------------부품 검색---------------");
		System.out.println("1.  CPU ");
		System.out.println("2.  MainBoard ");
		System.out.println("3.  HDD ");
		System.out.println("4.  SSD ");
		System.out.println("5.  OS ");
		System.out.println("6.  RAM ");
		System.out.println("7.  VGA ");
		System.out.println("8.  POWER ");
		System.out.println("9.  CASE ");
		System.out.println("10. ODD");
		System.out.println(" -----------------------------------------");
		System.out.print("선택 : ");
		int select = scan.nextInt();

		switch (select) {
		case 1:

			partsName = "cpu";
			break;

		case 2:

			partsName = "mainboard";
			break;

		case 3:

			partsName = "hdd";
			break;

		case 4:

			partsName = "ssd";
			break;

		case 5:

			partsName = "operatingsystem";
			break;

		case 6:

			partsName = "ram";
			break;

		case 7:

			partsName = "vga";
			break;

		case 8:

			partsName = "power";
			break;

		case 9:

			partsName = "case";
			break;

		case 10:

			partsName = "odd";
			break;

		default:
			System.out.println("해당 부품은 존재하지 않습니다.");
			break;
		}

		List<ItemDTO> list = itemDao.partsConfirm(partsName);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(
					(i + 1) + ". [부품 종류] : " + partsName.toUpperCase() + "  [부품 이름] : " + list.get(i).getItemName());
		} // end of for
	}// end of partsConfirm
} // end of SearchOfNameService
