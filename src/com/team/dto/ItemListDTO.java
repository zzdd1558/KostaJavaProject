package com.team.dto;

//oracle database table : itemlist
public class ItemListDTO {
	
	private String code; // col : code
	private String kind; // col : kind
	
	//생성자 
	public ItemListDTO() {
		// TODO Auto-generated constructor stub
	}
	public ItemListDTO(String code, String kind) {
		super();
		this.code = code;
		this.kind = kind;
	}
	
	
	//setter , getter 
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	
}
