package com.allianz.shopping.model;

public class AddToCart {
	private int id;
	private int product_id;
	private int quantity;
	private float total;
	private int order_id;

	//Getters And Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public AddToCart(int id, int product_id, int quantity, float total, int order_id) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.total = total;
		this.order_id = order_id;
	}
	public AddToCart() {
		super();
	}
}
