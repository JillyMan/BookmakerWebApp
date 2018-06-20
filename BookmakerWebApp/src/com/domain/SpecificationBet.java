package com.domain;

import com.domain.enums.StatusBets;
import com.jdbs.interfaces.Identified;

public class SpecificationBet implements Identified<Integer>{
	private Integer id;
	private Integer typebetsId;
	private double coefficient;
	private StatusBets result;
	private Integer eventId;
	
	public SpecificationBet (Integer typebetsid, double coefficient, StatusBets result, Integer eventid) {
		this.typebetsId = typebetsid;
		this.coefficient = coefficient;
		this.result = result;
		this.eventId = eventid;
	}

	@Override
	public String toString() {
		return id + " " +  typebetsId + " " + coefficient +  " " + result + " " + eventId;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getTypeBetsId() {
		return typebetsId;
	}

	public void setTypeBetsId(Integer typebetsid) {
		this.typebetsId = typebetsid;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public StatusBets getResult() {
		return result;
	}

	public void setResult(StatusBets result) {
		this.result = result;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventid) {
		this.eventId = eventid;
	}
}	
