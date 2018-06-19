package com.base_type;

public class User {
	private int id;
	private int score;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private Role role;
	
	public User() {}
	
	public User(String fName, String lName, int score, String login, String password, Role role) {
		this.firstName = fName;
		this.lastName = lName;
		this.score = score;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return id + " " + firstName + " " + lastName + " " + score + " " + login + " " + password + " " + role;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
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
	
	public int getId() {
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
