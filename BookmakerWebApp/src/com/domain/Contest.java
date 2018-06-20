package com.domain;

public class Contest {
	private Integer eventId;
	private Integer teamId;

	@Override
	public String toString() {
		return eventId + " " + teamId;
	}
	
	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer event) {
		this.eventId = event;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamid) {
		this.teamId = teamid;
	}

	public Contest(Integer eventid, Integer teamid) {
		super();
		this.eventId = eventid;
		this.teamId = teamid;
	}
}
