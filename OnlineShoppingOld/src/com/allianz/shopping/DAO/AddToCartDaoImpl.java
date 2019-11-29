package com.allianz.shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.allianz.shopping.model.AddToCart;
import com.allianz.shopping.utility.DBUtility;

public class AddToCartDaoImpl implements AddToCartDao {

	@Override
	public boolean addtoCart(AddToCart addToCart) {
		String sql = "insert into addtocart(product_id , quantity , total , order_id) values(?,?,?,?)";
		Connection con;
		//int orderId=0;
		try
		{
			con=DBUtility.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			//pst.setInt(1,addToCart.getId());
			pst.setInt(1, addToCart.getProduct_id());
			pst.setInt(2, addToCart.getQuantity());
			pst.setFloat(3, addToCart.getTotal());
			pst.setInt(4, addToCart.getOrder_id());
			int result = pst.executeUpdate();
			if(result > 0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<AddToCart> getAllAddToCartByOrderId(int order_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
