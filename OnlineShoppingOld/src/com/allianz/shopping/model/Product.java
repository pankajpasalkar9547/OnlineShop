package com.allianz.shopping.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {
	private int id;
	private String code,description;
	private float price;
	private Date manifacturefDate;
	private List<Category> category_list = new ArrayList<Category>(); 
	public int getId() {
		return id;
	}
	public List<Category> getCategory_list() {
		return category_list;
	}
	public void setCategory_list(List<Category> category_list) {
		this.category_list = category_list;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public Product(int id, String code, String description, float price, Date manifacturefDate) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.price = price;
		this.manifacturefDate = manifacturefDate;
	}
	public Product() {
		super();
	}
	public Date getManifacturefDate() {
		return manifacturefDate;
	}
	public void setManifacturefDate(Date manifacturefDate) {
		this.manifacturefDate = manifacturefDate;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", description=" + description + ", price=" + price
				+ ", manfdate=" + manifacturefDate + "]";
	}
	
	

}
