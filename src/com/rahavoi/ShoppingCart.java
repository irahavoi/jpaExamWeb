package com.rahavoi;

import java.io.IOException;
import java.io.Writer;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rahavoi.ejb.HelloPojo;
import com.rahavoi.ejb.ShoppingBean;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ShoppingBean shoppingBean;
	@Inject
	private HelloPojo helloPojo;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Writer writer = response.getWriter();
		
		writer.append("<html>");
		writer.append("<body>");
		writer.append("<h1>Welcome to Shopping Cart Servlet</h1>");
		writer.append("<h3>Injected ejb's info: " + shoppingBean.getBeanInfo() +   "</h3>");
		writer.append("<h3>Injected cdi bean's info: " + helloPojo.sayHello() +   "</h3>");
		writer.append("</body>");
		writer.append("</html>");
	}

}
