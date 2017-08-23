package com.team.selftest;

import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.join.JoinService;

public class SelfTest {
	
	public static void main(String[] args) {
		
		MemberTest();
//		AddData.initiate();
		
	}//end of main
	
	public static void MemberTest() {
		
		Scanner sc = new Scanner(System.in);
		
		MemberDao.deleteAll();
		
		MemberDao.add(new MemberDTO("scott","tiger","�뒪罹�","90000","scott.com","�꽌�슱","01022445555"));
		MemberDao.add(new MemberDTO("tiger","scott","���씠嫄�","102010","tiger.com","�꽌�슱","01033995030"));
		MemberDao.add(new MemberDTO("changuk","test","李쎌슧","120002","changuk.com","�슱�궛","0103910395"));
		MemberDao.add(new MemberDTO("test","1234","�뀒�뒪�듃","903020","test.com","遺��궛","01022224242"));
		
//		new LoginService().login(sc);
		new JoinService().exec(sc);
		
	}//end of MemberTest
	
}//end of SelfTest
