package com.domain.enums;

public enum StatusBets {
	WIN(1),
	LOSE(2),
	NONE(-1);
	
	private final int value;
	
	StatusBets(int val) {
		value = val;
	}

	public int getInt() {
		return value;
	}
	
	public static StatusBets getStatus(int val) {
		StatusBets status = NONE;

		if(val == 1) {
			status = WIN;
			
		} else if(val == 2) {
			status = LOSE;			
		}
		
		return status;
	}	
}
