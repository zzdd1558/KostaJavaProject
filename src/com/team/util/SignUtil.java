package com.team.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import com.team.dto.MemberDTO;

public class SignUtil {

	// 사용자로 부터 입력받은 비밀번호 암호화
	public static void passwordEncryption(String password, MemberDTO m) {
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
			byte[] md5Msg = sha256.digest(password.getBytes());
			StringBuilder saltKey = new StringBuilder();
			StringBuilder formatValue = new StringBuilder();
			for (Byte x : md5Msg) {

				formatValue.append(String.format("%02X", x));
			}

			for (Byte x : random) {
				saltKey.append(String.format("%02X", x));
			}
			m.setPwd(formatValue.toString());
			m.setSaltKey(saltKey.toString().trim());
			/**/
		} catch (NoSuchAlgorithmException e) {
		}
	} // end of passwordEncryption
	
	
	/** 로그인시 입력받은 비밀번호를 암호화하여 DB에있는 비밀번호와 일치여부 확인*/
	/** 일치할경우 true 일치하지 않을경우 false 반환*/
	public static boolean passwordConfirm(String password, MemberDTO member) {
		StringBuilder sb = null;
		try {

			// SHA-256
			// 실제로 암호화할때 쓰는 암호화 방식 SHA-256
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");

			String hexaDecimal = member.getSaltKey();
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

		} catch (NoSuchAlgorithmException e) {
		}

		return sb.toString().equals(member.getPwd()) ? true : false;
	} // end of passwordConfirm
}
