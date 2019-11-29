package com.allianz.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.allianz.shopping.DAO.CustomerDAO;
import com.allianz.shopping.DAO.CustomerDAOImpl;
import com.allianz.shopping.model.Customer;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static CustomerDAO customerDAO = new CustomerDAOImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequestrequest, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//For Register
		int id = Integer.parseInt(request.getParameter("id"));
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		Customer customer = new Customer(id, user, mobile, pass);
		boolean flag = customerDAO.addCustomer(customer);
		if(flag)
		{
			response.sendRedirect("Login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//For Login
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		boolean flag = customerDAO.login(user, pass);
		if(flag)
		{
			HttpSession session = request.getSession();
			session.setAttribute("hello", user);
			response.sendRedirect("ProductController");
		}
		//doGet(request, response);
	}
}
