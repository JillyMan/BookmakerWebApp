package com.base_type;

public enum StatusBets {
	NONE,
	WIN,
	LOSE;
	
	public static StatusBets getStatus(int val) {
		StatusBets status = null;
		switch(val) {
			case -1:{
				status = NONE;
			}break;
			case 2:{
				status = WIN;				
			}break;
			case 3:{
				status = LOSE;				
			}break;
			default:{}
			break;
		}
		return status;
	}
	
}
