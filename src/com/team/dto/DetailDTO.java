package com.team.dto;

// oracle database table : detail
public class DetailDTO {
	private int orderNum; // col : order_num
	private int itemNum; // col : item_num
	private int amount; // col : amount

	// 생성자 
	public DetailDTO() {
	}
	///
	public DetailDTO(int orderNum, int itemNum, int amount) {
		super();
		this.orderNum = orderNum;
		this.itemNum = itemNum;
		this.amount = amount;
	}
	
	
	// setter , getter
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getItemNum() {
		return itemNum;
	}
	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	} 
	
	
}
