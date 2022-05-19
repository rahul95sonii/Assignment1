package com.example.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service

public class CurrencyService {

	@Autowired(required = true)
	private Currencyrepository repo;
	
	
	// to get the balance
	public int getBalance(long account_number) {
		return repo.findBalanceByAcctID(account_number);
	}
	
	public void amountDeposit(long account_number, double amount) {
		repo.saveBalanceByAcctID(account_number, amount);
	}
	
	public void Amountwithdraw(long account_number, double amount) {
		repo.withdrawAmount(account_number, amount);
	}
	
	public void transferAmount(long account_number, long destaccount_number, double amount) {
		repo.withdrawAmount(account_number, amount);
		repo.saveBalanceByAcctID(destaccount_number, amount);
	}
	public String getAssettype(long  account_number) {
		return repo.findAssettype(account_number);
	}
	
	
}
