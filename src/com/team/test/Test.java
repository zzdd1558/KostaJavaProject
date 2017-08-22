package com.team.test;

import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.join.LoginService;

/** Test를 위한 클래스 */
public class Test {

	public static void main(String[] args) {
		
		MemberTest();
//		AddData.initiate();
		
	}//end of main
	
	public static void MemberTest() {
		
		Scanner sc = new Scanner(System.in);
		
		MemberDao.deleteAll();
		
		MemberDao.add(new MemberDTO("scott","tiger","스캇","90000","scott.com","서울","01022445555"));
		MemberDao.add(new MemberDTO("tiger","scott","타이거","102010","tiger.com","서울","01033995030"));
		MemberDao.add(new MemberDTO("changuk","test","창욱","120002","changuk.com","울산","0103910395"));
		MemberDao.add(new MemberDTO("test","1234","테스트","903020","test.com","부산","01022224242"));
		
		new LoginService().exec(sc);
	}//end of MemberTest
	
}//end of Test
