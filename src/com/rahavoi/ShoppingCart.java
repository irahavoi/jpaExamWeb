package com.rahavoi;

import java.io.IOException;
import java.io.Writer;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rahavoi.ejb.CartBean;
import com.rahavoi.ejb.HelloPojo;
import com.rahavoi.ejb.ShoppingBean;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
@EJB(name="cart", beanInterface=CartBean.class)
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
		HttpSession session = request.getSession(true);
		CartBean cart = (CartBean)session.getAttribute("cart");
		
		if(cart == null){
			try{
				javax.naming.Context ctx = new InitialContext();
				cart = (CartBean) ctx.lookup("java:comp/env/cart");
				session.setAttribute("cart", cart);
			} catch(NamingException e){
				throw new ServletException(e);
			}
		}
		
		Writer writer = response.getWriter();
		
		
		writer.append("<html>");
		writer.append("<body>");
		writer.append("<h1>Welcome to Shopping Cart Servlet</h1>");
		writer.append("<h3>Injected ejb's info: " + shoppingBean.getBeanInfo() +   "</h3>");
		writer.append("<h3>Injected cdi bean's info: " + helloPojo.sayHello() +   "</h3>");
		//writer.append("<h3>Stateful session bean's info: " + cart.getInfo() +   "</h3>");
		writer.append("</body>");
		writer.append("</html>");
	}

}
