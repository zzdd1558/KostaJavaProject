package com.team.join;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Scanner;

import com.team.dao.MemberDao;
import com.team.dto.MemberDTO;
import com.team.util.Service;

/** 회원 가입 관련 클래스 */
public class JoinService implements Service {

	@Override
	public void exec(Scanner scan, String id, Map<Integer, Integer> map) {

		MemberDTO m = new MemberDTO();

		System.out.print("아이디: ");
		m.setId(scan.nextLine());

		// 중복 아이디가 있는지 체크
		if (MemberDao.checkId(m.getId())) {
			System.out.println("아이디가 중복됩니다.");
			return;
		}

		System.out.print("비밀번호: ");
		try {
			// 시큐어 랜덤값 생성
			byte[] random = new byte[10];
			SecureRandom rs = new SecureRandom().getInstance("SHA1PRNG");

			// 0으로 초기화되어 있는 random 에 랜덤값을 채워준다.
			rs.nextBytes(random);

			// MD5
			// 실제로 암호화할때 쓰는 암호화 방식 MD5
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

			sha256.update(random);
			byte[] md5Msg = sha256.digest(scan.nextLine().getBytes());
			StringBuilder saltKey = new StringBuilder();
			StringBuilder formatValue = new StringBuilder();
			for (Byte x : md5Msg) {
				
				formatValue.append(String.format("%02X", x));
			}
			
			for (Byte x : random) {
				saltKey.append(String.format("%02X",x));
			}
			m.setPwd(formatValue.toString());
			m.setSaltKey(saltKey.toString().trim());
			/**/
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.print("이름: ");
		m.setName(scan.nextLine());

		System.out.print("생일: ");
		m.setBirth(scan.nextLine());

		System.out.print("이메일: ");
		m.setMail(scan.nextLine());

		System.out.print("주소: ");
		m.setAddr(scan.nextLine());

		System.out.print("전화번호: ");
		m.setPhone(scan.nextLine());

		if (MemberDao.add(m) != 0)
			System.out.println("회원 가입에 성공하셨습니다.");
		else
			System.out.println("회원 가입에 실패했습니다.");

	}// end of exec

}// end of Join
