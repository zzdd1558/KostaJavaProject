package com.team.dto;

//oracle database table : items
public class ItemDTO {
	private int itemNum; // col : item_num
	private String company; // col : company
	private String itemName; // col : item_name
	private String etc; // col : etc
	private String price; // col : price
	private String code; // col : code
	private String listName;
	// 생성자
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}

	public ItemDTO(String company) {
		super();
		this.company = company;
	}

	public ItemDTO(int itemNum, String company, String itemName, String etc, String price, String code) {
		super();
		this.itemNum = itemNum;
		this.company = company;
		this.itemName = itemName;
		this.etc = etc;
		this.price = price;
		this.code = code;
	}

	// setter , getter
	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	@Override
	public String toString() {
		return  "[부품 종류] : " + listName + ", [부품번호] : " + itemNum + ", [제조사] : " + company + ", [부품 이름] : "  + itemName + ", [상세정보] : " + etc
				+ ", [가격] : " + price;
	}
	
	
}
