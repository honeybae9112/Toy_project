package com.honeybae.project.dto;

public class Member {
	private int id;
	private String email;
	private String password;
	private String name;
	private String nickName;
	private String phone;
	private int zipcode;
	private String address;
	private int role;
	private String registerDate;
	private Boolean deleteFlag;
	private String deleteDate;
	
	public Member() {
	}
	public Member(int id, String email, String password, String name, String nickName, String phone, int zipcode,
			String address, int role, String registerDate, Boolean deleteFlag, String deleteDate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.phone = phone;
		this.zipcode = zipcode;
		this.address = address;
		this.role = role;
		this.registerDate = registerDate;
		this.deleteFlag = deleteFlag;
		this.deleteDate = deleteDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(String deleteDate) {
		this.deleteDate = deleteDate;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", nickName="
				+ nickName + ", phone=" + phone + ", zipcode=" + zipcode + ", address=" + address + ", role=" + role
				+ ", registerDate=" + registerDate + ", deleteFlag=" + deleteFlag + ", deleteDate=" + deleteDate + "]";
	}
	
	
	
}


