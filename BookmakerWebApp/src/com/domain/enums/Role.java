package com.domain.enums;

public enum Role {
	USER(1),
	ADMIN(2),
	BOOKMAKER(3),
	UNKNOWN(4);
	
	private final int value;

	Role(int val){
		value = val;
	}
	
	public int getInt() {
		return value;
	}
}