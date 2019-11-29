package com.allianz.shopping.DAO;

import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;

public interface ProductDAO {
	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int id);
	public List<Product> getAllProduct();
	public List<Product> getAllProductsByName(String namePattern);
	public List<Product> getAllProductsByPrice(float min, float max);
	public Product getProductById(int id);
	public List<Product> getAllProductByCategoryId(int id);
}
