package com.allianz.shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DBUtility;
import com.allianz.shopping.utility.DateUtil;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public boolean addCategory(Category category) {
		Connection con;
		try
		{
			con =DBUtility.getConnection();
			String sql = "insert into Category (category_id,category_name,category_details) values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, category.getCategoryId());
			pst.setString(2, category.getCategoryName());
			pst.setString(3, category.getCategoryDetails());
			int no = pst.executeUpdate();
			if(no > 0)
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
	public boolean updateCategory(Category category) {
		Connection con;
		try
		{
			con =DBUtility.getConnection();
			String sql = "UPDATE category SET category_name=?,category_details=?,where category_id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, category.getCategoryName());
			pst.setString(2, category.getCategoryDetails());
			pst.setFloat(3, category.getCategoryId());
			
			int no = pst.executeUpdate();
			if(no > 0)
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
	public boolean deleteCategory(int id) {
		Connection con;
		try
		{
			con=DBUtility.getConnection();
			String sql = "DELETE FROM Category where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			int no = pst.executeUpdate();
			if(no > 0)
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
	public List<Category> getAllCategory() {
		Connection con;
		try
		{
			//System.err.println("KKKK");
			con = DBUtility.getConnection();
			String sql = "SELECT * FROM category";
			List<Category> categoryList = new ArrayList<Category>();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Category category = new Category();
				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setCategoryDetails(rs.getString(3));
				categoryList.add(category);
			}
			return categoryList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAllCategoryByName(String namePattern) {
		return null;
	}

	@Override
	public List<Category> getAllCategoryByPrice(float min, float max) {
		return null;
	}

	@Override
	public Category getProductById(int id) {
		return null;
	}
	
	public List<Category> getAllCategoryByProduct(int id)
	{
		Connection con;
		//Product product = new Product();
		List<Category> categoryList = new ArrayList<Category>();
		Category category = new Category();
		try
		{
			con=DBUtility.getConnection();
			String sql = "Select * from category where category_id in ("
					+ "select category_id from product_category where id = ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				category.setCategoryId(rs.getInt(1));
				category.setCategoryName(rs.getString(2));
				category.setCategoryDetails(rs.getString(3));
				categoryList.add(category);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return categoryList;
	}

}
