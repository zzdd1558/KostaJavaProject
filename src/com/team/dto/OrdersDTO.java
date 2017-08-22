package com.team.dto;


//oracle database table : orders
public class OrdersDTO {
	private int orderNum;		// col : order_num
	private String id; 			// col : id 
	private String addr;		// col : getAddr
	private String name;		// col : getName
	private String phone;		// col : getPhone
	private String orderTime;	// col : order_time
	
	//생성자
	public OrdersDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public OrdersDTO(int orderNum, String id, String addr, String name, String phone, String orderTime) {
		super();
		this.orderNum = orderNum;
		this.id = id;
		this.addr = addr;
		this.name = name;
		this.phone = phone;
		this.orderTime = orderTime;
	}
	
	
	// setter , getter 
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	
	
	
}
