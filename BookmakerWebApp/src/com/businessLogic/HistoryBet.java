package com.businessLogic;

import com.domain.enums.StatusBets;

public class HistoryBet {
	private String nameEvent;
	private String bets;
	private double coefficient;
	private int summa;
	private StatusBets status;
	
	public HistoryBet(String nameEvent, String bets, double coefficient, int summa, StatusBets status) {
		super();
		this.nameEvent = nameEvent;
		this.bets = bets;
		this.coefficient = coefficient;
		this.summa = summa;
		this.status = status;
	}
	public String getNameEvent() {
		return nameEvent;
	}
	
	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}
	

	public String getBets() {
		return bets;
	}
	public void setBets(String bets) {
		this.bets = bets;
	}
	public double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	public int getSumma() {
		return summa;
	}
	public void setSumma(int summa) {
		this.summa = summa;
	}
	public StatusBets getStatus() {
		return status;
	}
	public void setStatus(StatusBets status) {
		this.status = status;
	}
}
