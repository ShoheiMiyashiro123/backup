package com.internousdev.login.dto;

public class LoginDTO {
	private int userId;
	private String name;
	private String password;

	public int getuserId(){
		return userId;
	}

	public void setuserId(int userId){
		this.userId=userId;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}
}
