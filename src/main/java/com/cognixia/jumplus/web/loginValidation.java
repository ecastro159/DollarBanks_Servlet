package com.cognixia.jumplus.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import com.cognixia.jumplus.DAO.CustomerDAOClass;
import com.cognixia.jumplus.model.Customer;

/**
 * Servlet implementation class loginValidation
 */
public class loginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerDAOClass sqlCustomer = new CustomerDAOClass();

	public loginValidation() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (checkLogin(request, response)) {
			int userID = Integer.parseInt(request.getParameter("userID"));
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);

			Customer customer = sqlCustomer.customerInfo(userID);
			session.setAttribute("userName", customer.getFirstName());

			response.sendRedirect("home");

		} else {
			response.sendRedirect("login");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private boolean checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int userID = Integer.parseInt(request.getParameter("userID"));
		String password = request.getParameter("password");

		if (sqlCustomer.checkLogIn(userID, password)) {
			return true;

		} else {
			return false;
		}

	}

}
