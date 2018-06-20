package com.base_type;

public class Team {
	private int id;
	private String nameTeam;
	
	public Team(String nameTeam) {
		this.nameTeam = nameTeam;
	}

	public int getId() {
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
