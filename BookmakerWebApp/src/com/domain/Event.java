package com.domain;

import java.sql.Timestamp;
import com.jdbs.interfaces.Identified;

public class Event implements Identified<Integer> {
	private Integer id;
	private String nameEvent;
	private Timestamp timestamp;
	private Integer typeSportId;
	
	public Event(String nameEvent, Timestamp timestamp, Integer typeSportid) {
		this.nameEvent = nameEvent;
		this.timestamp = timestamp;
		this.typeSportId = typeSportid;
	}

	@Override
	public String toString() {
		return id + " " + nameEvent + " " + timestamp.toString() + " " + typeSportId;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Timestamp time) {
		this.timestamp = time;
	}

	public Integer getId() {
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

	public Integer getTypeSportId() {
		return typeSportId;
	}

	public void setTypeSportId(Integer typeSportid) {
		this.typeSportId = typeSportid;
	}	
}
