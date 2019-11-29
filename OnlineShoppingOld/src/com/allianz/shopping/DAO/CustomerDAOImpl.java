package com.allianz.shopping.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.allianz.shopping.model.Customer;
import com.allianz.shopping.utility.DBUtility;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean addCustomer(Customer customer) {
		try(Connection con=DBUtility.getConnection();)
		{
			String sql = "insert into customer values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, customer.getCustomerId());
			pst.setString(2, customer.getUsername());
			pst.setString(3, customer.getPassword());
			pst.setLong(4, customer.getMobileNo());
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
	public boolean login(String username , String password) {
		try(Connection con=DBUtility.getConnection())
		{
			
			String sql = "SELECT * from customer";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String user = rs.getString("username");
				String pass = rs.getString("password");
				if(user.equalsIgnoreCase(username)&&pass.equalsIgnoreCase(password))
				{
					return true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<Customer>();
		try(Connection con=DBUtility.getConnection();)
		{
			
			String sql = "SELECT * FROM Customer";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt(1));
				customer.setUsername(rs.getString("username"));
				customer.setPassword(rs.getString("password"));
				customer.setMobileNo(rs.getInt(4));
				customerList.add(customer);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return customerList;
	}
}
