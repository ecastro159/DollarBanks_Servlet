package com.cognixia.jumplus.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.cognixia.jumplus.DAO.AccountDAOClass;
import com.cognixia.jumplus.DAO.TransactionDAOClass;

/**
 * Servlet implementation class Balance
 */
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDAOClass sqlAccount = new AccountDAOClass();
//	TransactionDAOClass sqlTransaction = new TransactionDAOClass();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Balance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		HttpSession session = request.getSession();
		int userID = (int) session.getAttribute("userID");
		
		double checkingBalance = sqlAccount.currentBalanceInChecking(userID);
		double savingsBalance = sqlAccount.currentBalanceInSavings(userID);
		session.setAttribute("CheckingBalance", checkingBalance);
		session.setAttribute("SavingsBalance", savingsBalance);
		response.sendRedirect("displayBalance");

		

		
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
