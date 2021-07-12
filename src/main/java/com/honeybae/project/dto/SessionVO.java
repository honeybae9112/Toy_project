package com.honeybae.project.dto;

public class SessionVO {
	private int id;
	private String email;
	private String name;
	private String nickName;
	private int role;
	

	public SessionVO(int id, String email, String name, String nickName, int role) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.nickName = nickName;
		this.role = role;
	}


	public int getId() {
		return id;
	}


	public String getEmail() {
		return email;
	}


	public String getName() {
		return name;
	}


	public String getNickName() {
		return nickName;
	}


	public int getRole() {
		return role;
	}

	

}
