package com.domain;

import com.domain.enums.Role;
import com.jdbs.interfaces.Identified;

public class User implements Identified<Integer>{
	private int id;
	private int score;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private int role;
	
	public User() {}
	
	public User(String fName, String lName, String login, String password) {
		this.firstName = fName;
		this.lastName = lName;
		this.score = 0;
		this.login = login;
		this.password = password;
		this.role = Role.USER.getInt();		
	}

	@Override
	public String toString() {
		return id + " " + firstName + " " + lastName + " " + score + " " + login + " " + password + " " + role;
	}
	
	public int  getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}
