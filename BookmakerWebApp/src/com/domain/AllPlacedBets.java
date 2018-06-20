package com.domain;

public class AllPlacedBets {
	private int summa;
	private Integer userId;
	private Integer betsId;
	
	public AllPlacedBets(Integer  userid, Integer betsid, int summa) {
		this.userId = userid;
		this.betsId = betsid;
		this.summa = summa;
	}
	
	@Override
	public String toString() {
		return userId + " " + betsId + " " + summa;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUser(Integer userid) {
		this.userId = userid;
	}
	public Integer getBetsId() {
		return betsId;
	}
	public void setBetsId(Integer event) {
		this.betsId = event;
	}
	public int getSumma() {
		return summa;
	}
	public void setSumma(int summa) {
		this.summa = summa;
	}
}
