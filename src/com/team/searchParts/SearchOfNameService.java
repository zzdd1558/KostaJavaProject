package com.team.searchParts;

import java.util.Scanner;

import com.team.dao.ItemDao;
import com.team.util.Service;

public class SearchOfNameService implements Service{

	/** 이름으로 부품 검색  */
	@Override
	public void exec(Scanner scan) {
		// TODO Auto-generated method stub
		ItemDao item = new ItemDao();
		System.out.println(" --------------- 부품 종류 ---------------");
		System.out.println(" CPU ");
		System.out.println(" Case ");
		System.out.println(" HDD ");
		System.out.println(" MainBoard ");
		System.out.println(" ODD ");
		System.out.println(" OperationgSystem ");
		System.out.println(" Power ");
		System.out.println(" Ram ");
		System.out.println(" SSD ");
		System.out.println(" VGA ");
		System.out.println(" ----------------------------------------- ");
		System.out.print(" 입력 : ");
		String partsName = scan.nextLine();
		item.searchForPartsByName();
		
	} // end of exec
} // end of SearchOfNameService
