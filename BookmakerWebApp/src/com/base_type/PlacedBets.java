package com.base_type;

public class PlacedBets {
	private User user;
	private Event event;
	private int summa;
	
	public PlacedBets(User user, Event event, int summa) {
		this.user = user;
		this.event = event;
		this.summa = summa;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public int getSumma() {
		return summa;
	}
	public void setSumma(int summa) {
		this.summa = summa;
	}
	
	
	
}
