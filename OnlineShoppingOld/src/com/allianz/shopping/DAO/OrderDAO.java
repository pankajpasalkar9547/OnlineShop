package com.allianz.shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.allianz.shopping.model.Order;
import com.allianz.shopping.utility.DBUtility;

public class OrderDAO {
	public int addOrder(Order order)
	{
		String sql = "insert into orders(status,username,total_Price) values(?,?,?)";
		Connection con;
		int orderId=0;
		try
		{
			con = DBUtility.getConnection();
			PreparedStatement psmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			System.out.println("Order is " + order);
			psmt.setInt(1, order.getStatus());
			psmt.setString(2, order.getUsername());
			psmt.setFloat(3, order.getTotalPrice());
			
			int result = psmt.executeUpdate();
			System.out.println(result);
			
			if(result > 0)
			{
				try(ResultSet generatedKeys = psmt.getGeneratedKeys())
				{
					if(generatedKeys .next())
					{
						orderId=generatedKeys.getInt(1);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderId;
	}

}
  