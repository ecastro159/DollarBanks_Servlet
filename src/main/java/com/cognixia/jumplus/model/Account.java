package com.cognixia.jumplus.model;

/**
 * Class that stores account information such as Account ID, Customer ID, Savings Balance, and Checking Balance
 * @author Erwin Castro
 *
 */

public class Account {

	private int account_id;
	private int customer_id;
	private double savings_Balance;
	private double checking_Balance;
	
	/**
	 * Returns the account ID
	 * @return The account ID number. The value will always be an integer.
	 */
	public int getAccount_id() {
		return account_id;
	}
	
	/**
	 * @param account_id
	 */

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	/**
	 * @return The customer_ID as an integer
	 */
	public int getCustomer_id() {
		return customer_id;
	}

	/**
	 * @param customer_id
	 */
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	/**
	 * @return Savings balance as a double
	 */
	public double getSavings_Balance() {
		return savings_Balance;
	}

	/**
	 * @param savings_Balance
	 */
	public void setSavings_Balance(double savings_Balance) {
		this.savings_Balance = savings_Balance;
	}

	/**
	 * @return Checking balance as a double
	 */
	public double getChecking_Balance() {
		return checking_Balance;
	}

	/**
	 * @param checking_Balance
	 */
	public void setChecking_Balance(double checking_Balance) {
		this.checking_Balance = checking_Balance;
	}

	/**
	 * Returns all account information as a string
	 */
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", customer_id=" + customer_id + ", savings_Balance="
				+ savings_Balance + ", checking_Balance=" + checking_Balance + "]";
	}

	/**
	 * @param customer_id
	 * @param checking_Balance
	 */
	public Account(int customer_id, double checking_Balance) {
		this.customer_id = customer_id;
		this.checking_Balance = checking_Balance;
	}

}
