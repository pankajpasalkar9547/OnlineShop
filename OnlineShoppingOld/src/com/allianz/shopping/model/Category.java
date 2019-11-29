package com.allianz.shopping.model;

public class Category {
	private int categoryId;
	private String categoryName;
	private String categoryDetails;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDetails() {
		return categoryDetails;
	}
	public void setCategoryDetails(String categoryDetails) {
		this.categoryDetails = categoryDetails;
	}
	public Category(int categoryId, String categoryName, String categoryDetails) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDetails = categoryDetails;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDetails="
				+ categoryDetails + "]";
	}
	
	

}
