package com.allianz.shopping.model;

public class Customer {
	private int customerId;
	private String username;
	private String password;
	private long mobileNo;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Customer(int customerId, String username, long mobileNo, String password) {
		super();
		this.customerId = customerId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public Customer() {
		super();
	}
}
