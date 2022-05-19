package com.example.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/hello")
public class CurrencyController {
	
	@Autowired (required = true)
	 private CurrencyService service1;
	
	//Task1  deposit amount 
	
	@PutMapping("account/{account_number}/deposit/{amount}")
	public String depositAmount(@PathVariable long account_number, @PathVariable double amount) {
		int balance =getBalance(account_number);
		System.out.println();
		service1.amountDeposit(account_number, balance);
		
		return "amount deposited successfuully";
	}
	
	@GetMapping("/account/{account_number}/balance")
	public int getBalance(@PathVariable long account_number) {
		return service1.getBalance(account_number);
	}
	
	@PutMapping("/account/{account_number}/withdraw/{amount}")
	public String withdrawAmount(@PathVariable long account_number, @PathVariable double amount) {
		int balance = getBalance(account_number);
		service1.Amountwithdraw(account_number, amount);
		return "amount withdrawn successfully";
	}
	
	@PutMapping("/account/{account_number}/transfer/{destaccount_number}/{amount}")
	public String transferAmount(@PathVariable long account_number, @PathVariable long  destaccount_number, @PathVariable double amount) {
		int initBalSender = getBalance(account_number);
		int initBalReceiver = getBalance(destaccount_number);
		String acc_assettype = service1.getAssettype(account_number);
		String des_assettype = service1.getAssettype(account_number);
		if (acc_assettype.equals(des_assettype))
		{
		service1.transferAmount(account_number, destaccount_number, amount);
		}
		else if (acc_assettype.equals("USD") && des_assettype.equals("BTC") )
		{
			double result=0.000034*amount;
			service1.transferAmount(account_number, destaccount_number, result);
		}
		
		else if (acc_assettype.equals("BTC") && des_assettype.equals("USD") )
		{
			double result=29842.80*amount;
			service1.transferAmount(account_number, destaccount_number, result);
		}
		
		else if (acc_assettype.equals("ETH") && des_assettype.equals("USD") )
		{
			double result=2023.14*amount;
			service1.transferAmount(account_number, destaccount_number, result);
		}
		else if (acc_assettype.equals("ETH") && des_assettype.equals("BTC") )
		{
			double result=0.06864*amount;
			service1.transferAmount(account_number, destaccount_number, result);
		}
		else if (acc_assettype.equals("BTC") && des_assettype.equals("ETH") )
		{
			double result=14.80*amount;
			service1.transferAmount(account_number, destaccount_number, result);
		}
		else if (acc_assettype.equals("USD") && des_assettype.equals("ETH") )
		{
			double result=0.00050*amount;
			service1.transferAmount(account_number, destaccount_number, result);
		}
		return "amount transferred succesfully";
	}
	
	
	
}
