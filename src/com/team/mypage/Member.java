package com.team.mypage;

import java.util.Scanner;

import com.team.util.Service;

public class Member {
	// my page
	public static String userId = "aaa";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Service memberInfo = new MemberInfoService();
		memberInfo.exec(sc);
	}

}
