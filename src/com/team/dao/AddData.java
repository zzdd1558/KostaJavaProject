<<<<<<< HEAD
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

/** ½ÃÀÛ½Ã ÇÊ¿äÇÑ µ¥ÀÌÅÍµéÀ» ÃÊ±âÈ­ ÇØÁÖ±â À§ÇÑ Å¬·¡½º */
public class AddData {

	/* º¯¼ö */
	static List<String> list; // ÆÄÀÏ ¸íµéÀ» ÀúÀåÇÒ º¯¼ö

	/* »ı¼ºÀÚ */
	static{

		// ÆÄÀÏ ¸íµéÀ» ¸®½ºÆ®¿¡ ÀúÀå
		list = Arrays.asList("Case", "CPU", "HDD", "MainBoard", "ODD", "OperatingSystem",
				"power", "Ram", "ssd", "vga");

	}

	/* ÇÔ¼ö */
	/** Å×ÀÌºí µ¥ÀÌÅÍ¸¦ ÃÊ±âÈ­ */
	public static void initiate() {
		
		//¸ğµç µ¥ÀÌÅÍ »èÁ¦ primary key¸¦ Æ÷ÇÔÇÏ´Â ¼ø¼­·Î Á¦°Å
		SequenceDao.deleteAll();
		ItemDao.deleteAll();
		ItemListDao.deleteAll();
		
		//¸ğµç µ¥ÀÌÅÍ »ğÀÔ foreign key¸¦ Æ÷ÇÔÇÏ´Â ¼ø¼­·Î »ı¼º
		SequenceDao.add();
		addItemListData();
		addItemData();
		
	}// end of Initiate
	
	/** itemlist µ¥ÀÌÅÍ¸¦ DB¿¡ ÀúÀå */
	private static void addItemListData() {
		
		int result = 0;
		
		for(String s:list) {

			result = ItemListDao.add(new ItemListDTO(list.indexOf(s)+"",s));
			
			if(result == 0) {
				System.out.println("½ÇÆĞÇß½À´Ï´Ù.");
				break;
			}
		}
		
	}//end of addItemListData

	/** ÆÄ½Ì ÈÄ µ¥ÀÌÅÍ¸¦ DB¿¡ ÀúÀå */
	private static void addItemData() {

		int result = 0;// ÀúÀå ¼º°ø ¿©ºÎ¸¦ ÀúÀåÇÒ º¯¼ö

		try {
			// DocumentBuilder¸¦ »ı¼ºÇØÁÖ´Â ÆÑÅä¸® - °´Ã¼ÀÇ Á¾·ù¸¦ ¼­ºêÅ¬·¡½º¿¡¼­ Á¤ÀÇ
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// DocumentBuilder »ı¼º
			DocumentBuilder builder = factory.newDocumentBuilder();

			// xmlÀ» ÆÄ½Ì(¹®¼­ ³»ºÎÀÇ µ¥ÀÌÅÍ °¡Á®¿À±â - ¸Ş¸ğ¸®¿¡ ¹®¼­ Æ®¸® ±¸Ãà)
			for (String s : list) {

				// ¸®½ºÆ® ¼ø¼­´ë·Î ÇÏ³ª¾¿ ÆÄ½Ì
				Document document = builder.parse(new FileInputStream(s+".xml"));

				// ÅÂ±× º°·Î ³ëµå ¸®½ºÆ® ¸¸µé±â
				NodeList names = document.getElementsByTagName("name");
				NodeList companies = document.getElementsByTagName("company");
				NodeList prices = document.getElementsByTagName("price");
				NodeList etcs = document.getElementsByTagName("etc");

				// ºÎÇ° Ãß°¡
				for (int i = 1; i < names.getLength(); i++) {

					String name = names.item(i).getTextContent();
					String company = companies.item(i).getTextContent();
					String price = prices.item(i).getTextContent();
					String etc = etcs.item(i).getTextContent();

					// ºÎÇ° ÄÚµå
					// 0.Case 1.CPU 2.HDD 3.MainBoard 4.ODD 5.OperatingSystem 6.Power 7.Ram 8.ssd
					// 9.vga
					result = ItemDao.add(new ItemDTO(0, company, name, etc, price, list.indexOf(s)+""));
					// ½ÇÆĞ½Ã¿¡ ¿Ã¶ó¿Ã ÇÔ¼ö
					if (result == 0) {
						System.out.println("½ÇÆĞÇß½À´Ï´Ù.");
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
=======
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

/** ì‹œì‘ì‹œ í•„ìš”í•œ ë°ì´í„°ë“¤ì„ ì´ˆê¸°í™” í•´ì£¼ê¸° ìœ„í•œ í´ë˜ìŠ¤ */
public class AddData {

	/* ë³€ìˆ˜ */
	static List<String> list; // íŒŒì¼ ëª…ë“¤ì„ ì €ì¥í•  ë³€ìˆ˜
//
	/* ìƒì„±ì */
	static{

		// íŒŒì¼ ëª…ë“¤ì„ ë¦¬ìŠ¤íŠ¸ì— ì €ì¥
		list = Arrays.asList("Case", "CPU", "HDD", "MainBoard", "ODD", "OperatingSystem",
				"power", "Ram", "ssd", "vga");

	}

	/* í•¨ìˆ˜ */
	/** í…Œì´ë¸” ë°ì´í„°ë¥¼ ì´ˆê¸°í™” */
	public static void initiate() {
		
		// ëª¨ë“  ë°ì´í„° ì‚­ì œ primary key ë¥¼ í¬í•¨í•˜ëŠ” ìˆœì„œë¡œ ì œê±°
		EventDao.deleteAll();
		SequenceDao.deleteAll();
		ItemDao.deleteAll();
		ItemListDao.deleteAll();
		MemberDao.deleteAll();
		OrdersDao.deleteAll();
		DetailDao.deleteAll();
		
		// ëª¨ë“  ë°ì´í„° ì‚½ì… foreign key ë¥¼ í¬í•¨í•˜ëŠ” ìˆœì„œë¡œ ìƒì„±
		SequenceDao.add();
		addItemListData();
		addItemData();
		
	}// end of Initiate
	
	/** itemlist ë°ì´í„°ë¥¼ DBì— ì €ì¥*/
	private static void addItemListData() {
		
		int result = 0;
		
		for(String s:list) {

			result = ItemListDao.add(new ItemListDTO(list.indexOf(s)+"",s));
			
			if(result == 0) {
				System.out.println("ì‹¤íŒ¨í–ˆìŠµë‹ˆë‹¤.");
				break;
			}
		}
		
	}//end of addItemListData

	/** íŒŒì‹± í›„ ë°ì´í„°ë¥¼ DBì— ì €ì¥ */
	private static void addItemData() {

		int result = 0;// ì €ì¥ ì„±ê³µ ì—¬ë¶€ë¥¼ ì €ì¥í•  ë³€ìˆ˜

		try {
			// DocumentBuilderë¥¼ ìƒì„±í•´ì£¼ëŠ” íŒ©í† ë¦¬ - ê°ì²´ì˜ ì¢…ë¥˜ë¥¼ ì„œë¸Œí´ë˜ìŠ¤ì—ì„œ ì •ì˜
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			// DocumentBuilder ìƒì„±
			DocumentBuilder builder = factory.newDocumentBuilder();

			// xmlì„ íŒŒì‹± ( ë¬¸ì„œ ë‚´ë¶€ì˜ ë°ì´í„° ê°€ì ¸ì˜¤ê¸° - ë©”ëª¨ë¦¬ì— ë¬¸ì„œ íŠ¸ë¦¬ êµ¬ì¶• )
			for (String s : list) { 

				// ë¦¬ìŠ¤íŠ¸ ìˆœì„œëŒ€ë¡œ í•˜ë‚˜ì”© íŒŒì‹±
				Document document = builder.parse(new FileInputStream(s+".xml"));

				// íƒœê·¸ ë³„ë¡œ ë…¸ë“œ ë¦¬ìŠ¤íŠ¸ ë§Œë“¤ê¸°
				NodeList names = document.getElementsByTagName("name");
				NodeList companies = document.getElementsByTagName("company");
				NodeList prices = document.getElementsByTagName("price");
				NodeList etcs = document.getElementsByTagName("etc");

				// ë¶€í’ˆ ì¶”ê°€
				for (int i = 1; i < names.getLength(); i++) {

					String name = names.item(i).getTextContent();
					String company = companies.item(i).getTextContent();
					String price = prices.item(i).getTextContent();
					String etc = etcs.item(i).getTextContent();

					// ë¶€í’ˆ ì½”ë“œ
					// 0.Case 1.CPU 2.HDD 3.MainBoard 4.ODD 5.OperatingSystem 6.Power 7.Ram 8.ssd
					// 9.vga
					result = ItemDao.add(new ItemDTO(0, company, name, etc, price, list.indexOf(s)+""));

					// ê²°ê³¼ í™•ì¸

					// 0ì´ë©´ ì¶”ê°€ ì‹¤íŒ¨.
					if (result == 0) {
						System.out.println("ì‹¤íŒ¨í–ˆìŠµë‹ˆë‹¤.");
						break;
					}
				}

			} // end of for

		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end of addItemData

}// end of AddData
>>>>>>> branch 'master' of https://github.com/zzdd1558/KostaJavaProject
