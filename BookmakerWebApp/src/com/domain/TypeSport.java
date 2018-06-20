package com.domain;

import com.jdbs.interfaces.Identified;

public class TypeSport implements Identified<Integer>{
	private Integer id;
	private String typeName;

	public TypeSport(String typeName) {
		this.typeName = typeName;
	}
	
	@Override
	public String toString() {
		return id + " " + typeName;
	}

	public Integer getId() {
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
