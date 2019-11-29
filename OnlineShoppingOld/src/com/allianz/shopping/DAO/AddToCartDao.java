package com.allianz.shopping.DAO;

import java.util.List;

import com.allianz.shopping.model.AddToCart;

public interface AddToCartDao {
	public boolean addtoCart(AddToCart addToCart);
	public List<AddToCart> getAllAddToCartByOrderId(int order_id);

}
