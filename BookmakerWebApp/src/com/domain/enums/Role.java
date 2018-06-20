package com.base_type;

public enum Role {
	USER,
	BOOKMAKER,
	ADMIN,
	UNKNOWN;

	public static Role toRole(int num) {
		Role role = null;
		switch(num) {
			case 1:{
				role = USER;
			}break;
			case 2:{
				role = ADMIN; 				
			}break;
			case 3:{
				role = BOOKMAKER; 				
			}break;
			default:
				role = UNKNOWN;
				break;
		}
		return role;
	}	
}
