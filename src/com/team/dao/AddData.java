package com.team.dao;

import java.io.FileInputStream;
import java.io.IOException;
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

/** ���۽� �ʿ��� �����͵��� �ʱ�ȭ ���ֱ� ���� Ŭ���� */
public class AddData {

	/* ���� */
	static List<String> list; // ���� ����� ������ ����

	/* ������ */
	static{

		// ���� ����� ����Ʈ�� ����
		list = Arrays.asList("Case", "CPU", "HDD", "MainBoard", "ODD", "OperatingSystem",
				"power", "Ram", "ssd", "vga");

	}

	/* �Լ� */
	/** ���̺� �����͸� �ʱ�ȭ */
	public static void initiate() {
		
		//��� ������ ���� primary key�� �����ϴ� ������ ����
		SequenceDao.deleteAll();
		ItemDao.deleteAll();
		ItemListDao.deleteAll();
		
		//��� ������ ���� foreign key�� �����ϴ� ������ ����
		SequenceDao.add();
		addItemListData();
		addItemData();
		
	}// end of Initiate
	
	/** itemlist �����͸� DB�� ���� */
	private static void addItemListData() {
		
		int result = 0;
		
		for(String s:list) {

			result = ItemListDao.add(new ItemListDTO(list.indexOf(s)+"",s));
			
			if(result == 0) {
				System.out.println("�����߽��ϴ�.");
				break;
			}
		}
		
	}//end of addItemListData

	/** �Ľ� �� �����͸� DB�� ���� */
	private static void addItemData() {

		int result = 0;// ���� ���� ���θ� ������ ����

		try {
			// DocumentBuilder�� �������ִ� ���丮 - ��ü�� ������ ����Ŭ�������� ����
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// DocumentBuilder ����
			DocumentBuilder builder = factory.newDocumentBuilder();

			// xml�� �Ľ�(���� ������ ������ �������� - �޸𸮿� ���� Ʈ�� ����)
			for (String s : list) {

				// ����Ʈ ������� �ϳ��� �Ľ�
				Document document = builder.parse(new FileInputStream(s+".xml"));

				// �±� ���� ��� ����Ʈ �����
				NodeList names = document.getElementsByTagName("name");
				NodeList companies = document.getElementsByTagName("company");
				NodeList prices = document.getElementsByTagName("price");
				NodeList etcs = document.getElementsByTagName("etc");

				// ��ǰ �߰�
				for (int i = 1; i < names.getLength(); i++) {

					String name = names.item(i).getTextContent();
					String company = companies.item(i).getTextContent();
					String price = prices.item(i).getTextContent();
					String etc = etcs.item(i).getTextContent();

					// ��ǰ �ڵ�
					// 0.Case 1.CPU 2.HDD 3.MainBoard 4.ODD 5.OperatingSystem 6.Power 7.Ram 8.ssd
					// 9.vga
					result = ItemDao.add(new ItemDTO(0, company, name, etc, price, list.indexOf(s)+""));
					// ���нÿ� �ö�� �Լ�
					if (result == 0) {
						System.out.println("�����߽��ϴ�.");
						break;
					}
				}

			} // end of for

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end of addItemData
	
	private static String getCode(int index) {
		
		return list.get(index);
		
	}//end of getCode

}// end of AddData
