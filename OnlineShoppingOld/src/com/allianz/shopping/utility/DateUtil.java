package com.allianz.shopping.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date convertStringToDate(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Date dateLocal;
		try
		{
			dateLocal = sdf.parse(date);
			return dateLocal; 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	public static String convertDateToString(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		String dateLocal;
		dateLocal = sdf.format(date);
		return dateLocal;
	}
	
	public static java.sql.Date convertUtilToSql(java.util.Date date)
	{
		java.sql.Date dateSql = new java.sql.Date(date.getTime());
		return dateSql;
	}

}
