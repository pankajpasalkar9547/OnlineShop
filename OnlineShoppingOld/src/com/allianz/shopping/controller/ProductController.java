package com.allianz.shopping.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allianz.shopping.DAO.CategoryDAO;
import com.allianz.shopping.DAO.CategoryDAOImpl;
import com.allianz.shopping.DAO.ProductDAO;
import com.allianz.shopping.DAO.ProductDAODataaseImpl;
import com.allianz.shopping.DAO.ProductDAOImpl;
import com.allianz.shopping.model.Category;
import com.allianz.shopping.model.Product;
import com.allianz.shopping.utility.DateUtil;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//static ProductDAODataaseImpl impl = new ProductDAODataaseImpl();
	static ProductDAO impl = new ProductDAODataaseImpl();
	static CategoryDAO categoryDAO = new CategoryDAOImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("delete"))
		{
			String id = request.getParameter("id");
			boolean flag = impl.deleteProduct(Integer.parseInt(id));
			if (flag)
			{
				response.sendRedirect("ProductController");
			}
		}
		
		else if(action != null && action.equals("edit"))
		{
			String id = request.getParameter("id");
			Product product = impl.getProductById(Integer.parseInt(id));
			if (product != null)
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Product.jsp");
				request.setAttribute("product",product);
				requestDispatcher.forward(request, response);
			}
		}
		
		else if(action != null && action.equals("details"))
		{
			String id = request.getParameter("id");
			Product product = impl.getProductById(Integer.parseInt(id));
			if (product != null)
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ProductDetails.jsp");
				request.setAttribute("product",product);
				requestDispatcher.forward(request, response);
			}
		}
		
		else if(action != null && action.equals("addToCart"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = impl.getProductById(id);
			if(product != null)
			{
				List<Product> productList = new ArrayList<Product>();
				if(request.getSession().getAttribute("productList")!= null)
				{
					productList=(List<Product>)request.getSession().getAttribute("productList");
					productList.add(product);
					request.getSession().setAttribute("productList",productList);	
				}
				else
				{
						productList.add(product);
						request.getSession().setAttribute("productList",productList);
				}
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddToCart.jsp");
				request.setAttribute("productList",productList);
				requestDispatcher.forward(request, response);
				
			}
		}
		
		else if(action != null && action.equals("deleteFromCart"))
		{
			String index = request.getParameter("index");
			List<Product> productList = new ArrayList<Product>();
			if(request.getSession().getAttribute("productList")!= null)
			{
				productList = (List<Product>)request.getSession().getAttribute("productList");
				productList.remove(Integer.parseInt(index));
				request.getSession().setAttribute("productList", productList);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("AddToCart.jsp");
			dispatcher.forward(request, response);
		}
		
		else if(action != null && action.equals("getAllProductByCategoryId"))
		{
			String id = request.getParameter("id");
			List<Product> product = impl.getAllProductByCategoryId(Integer.parseInt(id));
			List<Category>categoryList=new CategoryDAOImpl().getAllCategory();
			if (product != null)
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				request.setAttribute("categoryList",categoryList);
				request.setAttribute("product",product);
				requestDispatcher.forward(request, response);
			}
		}
		
		else if(action != null && action.equals("save"))
		{
			String id = request.getParameter("id");
			Product product = impl.getProductById(Integer.parseInt(id));
			if (product != null)
			{
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Product.jsp");
				request.setAttribute("product",product);
				requestDispatcher.forward(request, response);
			}
		}
		
		else
		{
			List<Product> productList = impl.getAllProduct();
			List<Category> categoryList = categoryDAO.getAllCategory();
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("productList",productList);
			request.setAttribute("categoryList", categoryList);
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("update"))
		{
			String id = request.getParameter("id");
			String code = request.getParameter("code");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String manfDate = request.getParameter("manfDate");
			Product product = new Product();
			product.setId(Integer.parseInt(id));
			product.setCode(code);
			product.setDescription(description);
			product.setPrice(Float.parseFloat(price));
			product.setManifacturefDate(DateUtil.convertStringToDate(manfDate));
			boolean flag=false;
			if(impl.getProductById(Integer.parseInt(id))!= null)
			{
				flag = impl.updateProduct(product);
			}
			else
			{
				flag = impl.addProduct(product);
			}
			if(flag)
			{
				response.sendRedirect("ProductController");
			}
		}
		doGet(request, response);
	}
}
