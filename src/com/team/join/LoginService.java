package com.team.join;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.main.MainInfoService;
import com.team.util.Service;

/** 로그인 기능을 제공하는 클래스 */
public class LoginService implements Service {

	@Override
	public void exec(Scanner scan, String ad, Map<Integer, Integer> map) {

		// 아이디 비밀번호 입력받기
		System.out.print("아이디를 입력하세요 : ");
		String id = scan.nextLine();

		System.out.print("비밀번호를 입력하세요 : ");
		String password = scan.nextLine();
		/* */
		MemberDTO t = MemberDao.getPwdAndKey(id);
		if (t == null) {
			System.out.println("없다");
		}
		StringBuilder sb = null;
		try {

			// MD5
			// 실제로 암호화할때 쓰는 암호화 방식 MD5
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

			String hexaDecimal = t.getSaltKey();
			byte[] buffer = new byte[hexaDecimal.length() / 2];
			for (int i = 0; i < buffer.length; i++) {
				buffer[i] = (byte) Integer.parseInt(hexaDecimal.substring(2 * i, 2 * i + 2), 16);
			}

			sha256.update(buffer);

			byte[] md5Msg = sha256.digest(password.getBytes());

			sb = new StringBuilder();
			for (byte x : md5Msg) {
				sb.append(String.format("%02X", x));
			}

			System.out.println(MessageDigest.isEqual(sb.toString().getBytes(), t.getPwd().getBytes()));
			System.out.println();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sb.toString().equals(t.getPwd())) {
			System.out.println("로그인에 성공했습니다.");
			new MainInfoService().exec(scan, id, map);
		} else {
			System.out.println("로그인에 실패했습니다.");
		}

	}// end of exec

}// end of LoginService
