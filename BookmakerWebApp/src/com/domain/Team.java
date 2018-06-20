package com.domain;

import com.jdbs.interfaces.Identified;

public class Team implements Identified<Integer>{
	private Integer id;
	private String nameTeam;
	
	public Team(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	@Override
	public String toString() {
		return id + " " + nameTeam;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameTeam() {
		return nameTeam;
	}

	public void setNameTeam(String nameTeam) {
		this.nameTeam = nameTeam;
	}
}
