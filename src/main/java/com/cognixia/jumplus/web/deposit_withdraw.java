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
 * Servlet implementation class deposit_withdraw
 */
public class deposit_withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDAOClass sqlAccount = new AccountDAOClass();
	TransactionDAOClass sqlTransaction = new TransactionDAOClass();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deposit_withdraw() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.sendRedirect("Balance");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("transaction");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String account = request.getParameter("account");

		HttpSession session = request.getSession();
		session.setAttribute("transaction", type);
		int userID = (int) session.getAttribute("userID");

		transactionTree(type, amount, account, userID);

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

	private void transactionTree(String type, double amount, String account, int id) {

		switch (type) {
		case "Deposit":
			if (account.equals("Checking")) {
				double balance = sqlAccount.currentBalanceInChecking(id);
				double newBalance = balance + amount;

				sqlAccount.depositToChecking(id, newBalance);
				sqlTransaction.addToHistory(id, "Deposit to Checking", amount);
			} else {
				double balance = sqlAccount.currentBalanceInSavings(id);
				double newBalance = balance + amount;

				sqlAccount.depositToSavings(id, newBalance);
				sqlTransaction.addToHistory(id, "Deposit to Savings", amount);
			}
			break;
		case "Withdraw":
			if (account.equals("Checking")) {
				double balance = sqlAccount.currentBalanceInChecking(id);
				double newBalance = balance - amount;

				sqlAccount.withdrawFromChecking(id, newBalance);
				sqlTransaction.addToHistory(id, "Withdraw from Checking", amount);
			} else {
				double balance = sqlAccount.currentBalanceInSavings(id);
				double newBalance = balance - amount;

				sqlAccount.withdrawFromSavings(id, newBalance);
				sqlTransaction.addToHistory(id, "Withdraw from Savings", amount);
			}
			break;
		default:
			System.out.println("Somthing Went Wrong!!!");
		}
	}

}
