package com.base_type;

public class SpecificationBet {
	private int id;
	private TypeBets typebets;
	private double coefficient;
	private int result;
	private Event event;
	
	public SpecificationBet (TypeBets typebets, double coefficient, int result, Event event) {
		this.typebets = typebets;
		this.coefficient = coefficient;
		this.result = result;
		this.event = event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TypeBets getTypebets() {
		return typebets;
	}

	public void setTypebets(TypeBets typebets) {
		this.typebets = typebets;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}	
