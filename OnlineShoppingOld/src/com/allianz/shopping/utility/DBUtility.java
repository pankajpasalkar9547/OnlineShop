package com.allianz.shopping.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	
	public static Connection getConnection()
	{
		Connection con ;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/shopping?serverTimezone=UTC", "root", "");
			return con;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
		
	}

}
