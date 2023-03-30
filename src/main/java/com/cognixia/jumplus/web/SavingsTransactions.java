package com.cognixia.jumplus.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jumplus.DAO.TransactionDAOClass;
import com.cognixia.jumplus.model.AccountTransactions;

/**
 * Servlet implementation class SavingsTransactions
 */
public class SavingsTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TransactionDAOClass sqlTransaction = new TransactionDAOClass();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavingsTransactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		HttpSession session = request.getSession();
		int userID = (int) session.getAttribute("userID");
		
		List<AccountTransactions> checkingList = sqlTransaction.getLastFiveTransaction(userID);
		List<String> checkingString = new ArrayList<String>();
		
		
		
		
		for(AccountTransactions e : checkingList) {
			checkingString.add(e.toString());
			
		}
		session.setAttribute("CheckingList", checkingString);
		for(String e: checkingString) {
			System.out.println(e);
		}
		
		response.sendRedirect("TransactionHistory");
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
