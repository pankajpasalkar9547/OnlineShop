package com.allianz.shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DBUtility;
import com.allianz.shopping.utility.DateUtil;

import javafx.application.Preloader;

public class ProductDAOImpl implements ProductDAO {
private static List<Product> productList=new ArrayList<Product>();
	static {
		productList.add(new Product(101,"Colgate1","Colgate1 Tube",50,DateUtil.convertStringToDate("12/12/12")));
		productList.add(new Product(102,"Colgate2","Colgate2 Tube",60,DateUtil.convertStringToDate("2/7/12")));
		productList.add(new Product(103,"Colgate3","Colgate3 Tube",80,DateUtil.convertStringToDate("15/6/12")));
		productList.add(new Product(104,"Colgate4","Colgate4 Tube",90,DateUtil.convertStringToDate("18/2/12")));

	}
	@Override
	public boolean addProduct(Product product) {
		productList.add(product);
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product producttemp=productList.get(i);
				if(producttemp.getId()==product.getId())
				{
					productList.set(i, product);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product producttemp=productList.get(i);
				if(producttemp.getId()==id)
				{
					productList.remove(i);
					return true;
				}
			}
		}
				return false;
	}

	@Override
	public List<Product> getAllProduct() {
		Connection con;
		try {
			con=DBUtility.getConnection();
			String sql="seect * from Product";
			List<Product> productList=new ArrayList<Product>();
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Product product =new Product();
				product.setId(rs.getInt(1));
			product.setCode(rs.getString(2));
			product.setDescription(rs.getString(3));
			product.setPrice(rs.getFloat(4));
			product.setManifacturefDate(rs.getDate(5));
			}
		}
		catch(Exception e) {
			
		}
		return productList;
	}

	@Override
	public List<Product> getAllProductsByName(String namePattern) {
		List<Product> productList=new ArrayList<Product>();
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product producttemp=productList.get(i);
				if(producttemp.getDescription().toLowerCase().contains(namePattern.toLowerCase()))
				{
					productList.add(producttemp);
					
				}
			}
			return productList;
		}
				
		return null;
	}

	@Override
	public List<Product> getAllProductsByPrice(float min, float max) {
		List<Product> productList=new ArrayList<Product>();
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product producttemp=productList.get(i);
				if(producttemp.getPrice()>=min && producttemp.getPrice()<=max)
				{
					productList.add(producttemp);
					
				}
			}
			return productList;
		}
		return null;
	}

	@Override
	public Product getProductById(int id) {
		if(productList!=null && productList.size()>0)
		{
			for(int i=0;i<productList.size();i++)
			{
				Product producttemp=productList.get(i);
				if(producttemp.getId()==id)
				{
					return producttemp;
				}
			}
		}
				return null;
	}

	@Override
	public List<Product> getAllProductByCategoryId(int id) {
		return null;
	}

}
