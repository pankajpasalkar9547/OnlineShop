package com.allianz.shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DBUtility;
import com.allianz.shopping.utility.DateUtil;

public class ProductDAODataaseImpl implements ProductDAO
{
	CategoryDAO categoryDAO = new CategoryDAOImpl();
	//ADD
	public boolean addProduct(Product product)
	{
		Connection con;
		try
		{
			con =DBUtility.getConnection();
			String sql = "insert into Product (id,code,description,price,mydate) values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, product.getId());
			pst.setString(2, product.getCode());
			pst.setString(3, product.getDescription());
			pst.setFloat(4, product.getPrice());
			pst.setDate(5, DateUtil.convertUtilToSql(product.getManifacturefDate()));
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
	
	//UPDATE
	public boolean updateProduct(Product product)
	{
		Connection con;
		try
		{
			con =DBUtility.getConnection();
			String sql = "UPDATE product SET code=?,description=?,price=?,mydate=? where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, product.getCode());
			pst.setString(2, product.getDescription());
			pst.setFloat(3, product.getPrice());
			pst.setDate(4, DateUtil.convertUtilToSql(product.getManifacturefDate()));
			pst.setInt(5, product.getId());
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
	
	//DELETE
	@Override
	public boolean deleteProduct(int id) {
		Connection con;
		try
		{
			con=DBUtility.getConnection();
			String sql = "DELETE FROM Product where id = ?";
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

	//ALLPRODUCT
	@Override
	public List<Product> getAllProduct() {
		Connection con;
		try
		{
			con = DBUtility.getConnection();
			String sql = "SELECT * FROM Product";
			List<Product> productList = new ArrayList<Product>();
			Statement pst = con.createStatement();
			ResultSet rs = pst.executeQuery(sql);
			while(rs.next())
			{
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setCode(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getFloat(4));
				product.setManifacturefDate(rs.getDate(5));
				productList.add(product);
			}
			return productList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<Product> getAllProductsByName(String namePattern) {
		return null;
	}

	@Override
	public List<Product> getAllProductsByPrice(float min, float max) {
		return null;
	}

	@Override
	public Product getProductById(int id) {
		Connection con;
		Product product = new Product();
		try
		{
			con=DBUtility.getConnection();
			String sql = "Select * from product where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				product.setId(rs.getInt(1));
				product.setCode(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getFloat(4));
				product.setManifacturefDate(rs.getDate(5));
				return product;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProductByCategoryId(int id) {
		Connection con;
		List<Product> productList = new ArrayList<Product>();
		Product product = new Product();
		try
		{
			
			con=DBUtility.getConnection();
			String sql = "Select * from product where id in ("
					+ "select id from product_category where category_id = ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				product.setId(rs.getInt(1));
				product.setCode(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setPrice(rs.getFloat(4));
				product.setManifacturefDate(rs.getDate(5));
				product.setCategory_list((List<Category>) categoryDAO.getAllCategoryByProduct(product.getId()));
				productList.add(product);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return productList;
	}
}
