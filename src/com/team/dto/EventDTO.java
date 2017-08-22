package com.team.dto;


//oracle database table : event
public class EventDTO {

	private int eventNum; // col : event_num
	private String eventName ; // col : event_name
	private String content;// col : content
	
	
	//생성자
	public EventDTO() {
	}
	
	public EventDTO(int eventNum, String eventName, String content) {
		super();
		this.eventNum = eventNum;
		this.eventName = eventName;
		this.content = content;
	}
	
	//setter , getter

	public int getEventNum() {
		return eventNum;
	}

	public void setEventNum(int eventNum) {
		this.eventNum = eventNum;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
