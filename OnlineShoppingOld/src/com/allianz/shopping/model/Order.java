package com.allianz.shopping.model;

public class Order {
	private int orderId;
	private int status;
	private String username;
	private float totalPrice;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Order(int orderId, int status, String username, float totalPrice) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.username = username;
		this.totalPrice = totalPrice;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", username=" + username + ", totalPrice="
				+ totalPrice + "]";
	}
}
