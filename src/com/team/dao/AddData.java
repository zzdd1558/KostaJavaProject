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

/** �떆�옉�떆 �븘�슂�븳 �뜲�씠�꽣�뱾�쓣 珥덇린�솕 �빐二쇨린 �쐞�븳 �겢�옒�뒪 */
public class AddData {

	/* 蹂��닔 */
	static List<String> list; // �뙆�씪 紐낅뱾�쓣 ���옣�븷 蹂��닔
//
	/* �깮�꽦�옄 */
	static{

		// �뙆�씪 紐낅뱾�쓣 由ъ뒪�듃�뿉 ���옣
		list = Arrays.asList("Case", "CPU", "HDD", "MainBoard", "ODD", "OperatingSystem",
				"power", "Ram", "ssd", "vga");

	}

	/* �븿�닔 */
	/** �뀒�씠釉� �뜲�씠�꽣瑜� 珥덇린�솕 */
	public static void initiate() {
		
		//紐⑤뱺 �뜲�씠�꽣 �궘�젣 primary key瑜� �룷�븿�븯�뒗 �닚�꽌濡� �젣嫄�
		SequenceDao.deleteAll();
		ItemDao.deleteAll();
		ItemListDao.deleteAll();
		
		//紐⑤뱺 �뜲�씠�꽣 �궫�엯 foreign key瑜� �룷�븿�븯�뒗 �닚�꽌濡� �깮�꽦
		SequenceDao.add();
		addItemListData();
		addItemData();
		
	}// end of Initiate
	
	/** itemlist �뜲�씠�꽣瑜� DB�뿉 ���옣 */
	private static void addItemListData() {
		
		int result = 0;
		
		for(String s:list) {

			result = ItemListDao.add(new ItemListDTO(list.indexOf(s)+"",s));
			
			if(result == 0) {
				System.out.println("�떎�뙣�뻽�뒿�땲�떎.");
				break;
			}
		}
		
	}//end of addItemListData

	/** �뙆�떛 �썑 �뜲�씠�꽣瑜� DB�뿉 ���옣 */
	private static void addItemData() {

		int result = 0;// ���옣 �꽦怨� �뿬遺�瑜� ���옣�븷 蹂��닔

		try {
			// DocumentBuilder瑜� �깮�꽦�빐二쇰뒗 �뙥�넗由� - 媛앹껜�쓽 醫낅쪟瑜� �꽌釉뚰겢�옒�뒪�뿉�꽌 �젙�쓽
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// DocumentBuilder �깮�꽦
			DocumentBuilder builder = factory.newDocumentBuilder();

			// xml�쓣 �뙆�떛(臾몄꽌 �궡遺��쓽 �뜲�씠�꽣 媛��졇�삤湲� - 硫붾え由ъ뿉 臾몄꽌 �듃由� 援ъ텞)
			for (String s : list) {

				// 由ъ뒪�듃 �닚�꽌��濡� �븯�굹�뵫 �뙆�떛
				Document document = builder.parse(new FileInputStream(s+".xml"));

				// �깭洹� 蹂꾨줈 �끂�뱶 由ъ뒪�듃 留뚮뱾湲�
				NodeList names = document.getElementsByTagName("name");
				NodeList companies = document.getElementsByTagName("company");
				NodeList prices = document.getElementsByTagName("price");
				NodeList etcs = document.getElementsByTagName("etc");

				// 遺��뭹 異붽�
				for (int i = 1; i < names.getLength(); i++) {

					String name = names.item(i).getTextContent();
					String company = companies.item(i).getTextContent();
					String price = prices.item(i).getTextContent();
					String etc = etcs.item(i).getTextContent();

					// 遺��뭹 肄붾뱶
					// 0.Case 1.CPU 2.HDD 3.MainBoard 4.ODD 5.OperatingSystem 6.Power 7.Ram 8.ssd
					// 9.vga
					result = ItemDao.add(new ItemDTO(0, company, name, etc, price, list.indexOf(s)+""));
					// �떎�뙣�떆�뿉 �삱�씪�삱 �븿�닔
					if (result == 0) {
						System.out.println("�떎�뙣�뻽�뒿�땲�떎.");
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
