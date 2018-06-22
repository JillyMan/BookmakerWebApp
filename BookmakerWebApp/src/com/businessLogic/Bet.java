package com.businessLogic;

import com.domain.Event;

public class Bet {	
	private Event event;
	private double TM;
	private double TL;
	private double WinOne;
	private double StandOf;
	private double WinTwo;

	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public double getTM() {
		return TM;
	}
	public void setTM(double tM) {
		TM = tM;
	}
	public double getTL() {
		return TL;
	}
	public void setTL(double tL) {
		TL = tL;
	}
	public double getWinOne() {
		return WinOne;
	}
	public void setWinOne(double winOne) {
		WinOne = winOne;
	}
	public double getStandOf() {
		return StandOf;
	}
	public void setStandOf(double standOf) {
		StandOf = standOf;
	}
	public double getWinTwo() {
		return WinTwo;
	}
	public void setWinTwo(double winTwo) {
		WinTwo = winTwo;
	}
	@Override
	public String toString() {
		return WinOne + " " + StandOf + " " + WinTwo + " " + TM + " " + TL;
	}
	
	public Bet(Event event, double win1, double x, double win2, double tm, double tl) {
		this.event = event;
		this.TM = tm;
		this.TL = tl;
		this.WinOne = win1;
		this.StandOf = x;
		this.WinTwo = win2;
	}
	
	public Bet() {}
}
