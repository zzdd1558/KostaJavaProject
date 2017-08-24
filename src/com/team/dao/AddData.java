package com.team.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.team.dto.ItemDTO;
import com.team.dto.ItemListDTO;

/** 시작시 필요한 데이터들을 초기화 해주기 위한 클래스 */
public class AddData {

	/* 변수 */
	static List<String> list; // 파일 명들을 저장할 변수
	//
	/* 생성자 */
	static {

		// 파일 명들을 리스트에 저장
		list = Arrays.asList("Case", "CPU", "HDD", "MainBoard", "ODD", "OperatingSystem", "power", "Ram", "ssd", "vga");

	}

	/* 함수 */
	/** 테이블 데이터를 초기화 */
	public static void initiate() {

		// 모든 데이터 삭제 primary key 를 포함하는 순서로 제거
		EventDao.deleteAll();
		SequenceDao.deleteAll();
		ItemDao.deleteAll();
		ItemListDao.deleteAll();
		MemberDao.deleteAll();
		OrdersDao.deleteAll();
		DetailDao.deleteAll();
		
		// 모든 데이터 삽입 foreign key 를 포함하는 순서로 생성
		SequenceDao.add();
		addItemListData();
		addItemData();

	}// end of Initiate

	/** itemlist 데이터를 DB에 저장 */
	private static void addItemListData() {

		int result = 0;
		for (String s : list) {
			result = ItemListDao.add(new ItemListDTO(list.indexOf(s) + "", s));

			if (result == 0) {
				System.out.println("실패했습니다.");
				break;
			}
		}

	}// end of addItemListData

	/** 파싱 후 데이터를 DB에 저장 */
	private static void addItemData() {

		int result = 0;// 저장 성공 여부를 저장할 변수
		try {
			// DocumentBuilder를 생성해주는 팩토리 - 객체의 종류를 서브클래스에서 정의
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// DocumentBuilder 생성
			DocumentBuilder builder = factory.newDocumentBuilder();

			List<ItemDTO> items = new ArrayList<>();

			// xml을 파싱 ( 문서 내부의 데이터 가져오기 - 메모리에 문서 트리 구축 )
			for (String s : list) {

				// 리스트 순서대로 하나씩 파싱
				Document document = builder.parse(new FileInputStream(s + ".xml"));

				// 태그 별로 노드 리스트 만들기
				NodeList names = document.getElementsByTagName("name");
				NodeList companies = document.getElementsByTagName("company");
				NodeList prices = document.getElementsByTagName("price");
				NodeList etcs = document.getElementsByTagName("etc");

				// 부품 추가
				for (int i = 1; i < names.getLength(); i++) {

					String name = names.item(i).getTextContent();
					String company = companies.item(i).getTextContent();
					String price = prices.item(i).getTextContent();
					String etc = etcs.item(i).getTextContent();

					// 부품 코드
					// 0.Case 1.CPU 2.HDD 3.MainBoard 4.ODD 5.OperatingSystem
					// 6.Power 7.Ram 8.ssd
					// 9.vga
					items.add(new ItemDTO(0, company, name, etc, Integer.parseInt(price), list.indexOf(s) + ""));
					
				} // end of for

			} // end of for
			
			ItemDao.add(items);
			
		} catch (ParserConfigurationException | SAXException |

				IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end of addItemData
}// end of AddData
