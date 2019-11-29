package com.allianz.shopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.DAO.AddToCartDao;
import com.allianz.shopping.DAO.AddToCartDaoImpl;
import com.allianz.shopping.DAO.OrderDAO;
import com.allianz.shopping.model.AddToCart;
import com.allianz.shopping.model.Order;

/**
 * Servlet implementation class CheckOutController
 */
@WebServlet("/CheckOutController")
public class CheckOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddToCartDao addToCartDao = new AddToCartDaoImpl();
    OrderDAO orderDAO = new OrderDAO();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOutController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("hello");
		String productId[] = request.getParameterValues("product_id");
		if(productId != null && productId.length>0)
		{
			float grandTotal = 0;
			for(int i=0;i<productId.length;i++)
			{
				String total = request.getParameter("total"+productId[i]);
				grandTotal = grandTotal + Float.parseFloat(total);
			}
			Order order = new Order();
			order.setStatus(1);
			order.setUsername(username);
			order.setTotalPrice(grandTotal);
			int orderId = orderDAO.addOrder(order);
			
			for(int i=0;i<productId.length;i++)
			{
				if(productId[i] != null && !productId[i].trim().equals(""))
				{
					System.out.println("inside for "+productId[i]);
					String quantity = request.getParameter("quantity"+productId[i]);
					String total = request.getParameter("total"+productId[i]);
					if(quantity != null)
					{
						System.out.println("innerrr");
						AddToCart addToCart = new AddToCart();
						addToCart.setOrder_id(orderId);
						addToCart.setQuantity(Integer.parseInt(quantity));
						addToCart.setProduct_id(Integer.parseInt(productId[i]));
						addToCart.setTotal(Float.parseFloat(total));
						addToCartDao.addtoCart(addToCart);
					}
				}
			}
			
			//List<Order> orderList = orderDAO.get
		}
	}
}
