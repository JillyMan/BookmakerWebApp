package com.base_type;

public class Contest {
	private int id;
	private Event event;
	private Team team;
	
	public Contest(int id, Event event, Team team) {
		super();
		this.id = id;
		this.event = event;
		this.team = team;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}	
}
