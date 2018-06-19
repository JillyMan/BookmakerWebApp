package com.base_type;

public class TypeBets {
	private int id;
	private String typeName;
	
	public TypeBets(String typeName) {
		this.typeName = typeName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}	
}
