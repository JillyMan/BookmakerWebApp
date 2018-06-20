package com.base_type;

import java.sql.Date;

public class Event {
	private int id;
	private String nameEvent;
	private Date date;
	private TypeSport typeSport;
	
	public Event(String nameEvent, Date date, TypeSport typeSport) {
		this.nameEvent = nameEvent;
		this.date = date;
		this.typeSport = typeSport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public TypeSport getTypeSport() {
		return typeSport;
	}

	public void setTypeSport(TypeSport typeSport) {
		this.typeSport = typeSport;
	}	
}
