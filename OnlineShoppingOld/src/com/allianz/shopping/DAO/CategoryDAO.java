package com.allianz.shopping.DAO;

import java.util.List;

import com.allianz.shopping.model.Category;


public interface CategoryDAO {
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(int id);
	public List<Category> getAllCategory();
	public List<Category> getAllCategoryByName(String namePattern);
	public List<Category> getAllCategoryByPrice(float min, float max);
	public Category getProductById(int id);
	public List<Category> getAllCategoryByProduct(int id);

}
