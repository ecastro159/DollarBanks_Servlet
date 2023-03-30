package com.cognixia.jumplus.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.cognixia.jumplus.model.Customer;
import com.cognixia.jumplus.DAO.CustomerDAOClass;
import com.cognixia.jumplus.DAO.AccountDAOClass;
import com.cognixia.jumplus.DAO.TransactionDAOClass;



/**
 * Servlet implementation class NewCustomer
 */

public class AddNewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	CustomerDAOClass sqlCustomer = new CustomerDAOClass();
	AccountDAOClass sqlAccount = new AccountDAOClass();
	TransactionDAOClass sqlTransaction = new TransactionDAOClass();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//		showNewCustomerForm(request, response);
		
		try {
			insertUser(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

	
	
	
	
//	private void showNewCustomerForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setAttribute("label", customerID);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("NewCustomer.jsp");
//		dispatcher.forward(request, response);
//	}

//	Inserts New Customer into the database from web page 
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String contactInfo = request.getParameter("ContactInfo");
		String password = request.getParameter("password");
		double deposit = Double.parseDouble(request.getParameter("deposit"));

		Customer customer = new Customer(firstName, lastName, contactInfo, password);
		int userID = sqlCustomer.createCustomer(customer);
		sqlAccount.depositNewAccount(userID, deposit);
		sqlTransaction.addToHistory(userID, "Deposit to Checking", deposit);
		
		
		HttpSession session = request.getSession();
		
		session.setAttribute("userID", userID);
		customer = sqlCustomer.customerInfo(userID);
		session.setAttribute("userName", customer.getFirstName());
		
		
		
		response.sendRedirect("home");
		

	}

}
