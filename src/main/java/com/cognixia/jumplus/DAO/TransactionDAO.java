package com.cognixia.jumplus.DAO;

import java.util.List;

import com.cognixia.jumplus.model.AccountTransactions;

public interface TransactionDAO {
	
    public void addToHistory(int userId, String transactionType, double amount);
    public List<AccountTransactions> getLastFiveTransaction(int userID);

}
