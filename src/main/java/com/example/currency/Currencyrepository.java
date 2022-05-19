package com.example.currency;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Currencyrepository extends JpaRepository<CurrencyModel, Long>,CrudRepository<CurrencyModel, Long> {

	@Query(value="select balance from Customer_Details where account_number= ?1",nativeQuery=true)
	@Modifying    
	public int findBalanceByAcctID(long account_number);
 
	@Query(value="select asset_type from Customer_Details where account_number= ?1",nativeQuery=true)
	@Modifying    
	public String findAssettype(long account_number);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update Customer_Details set amount = amount+?2 where account_number=?1",nativeQuery=true)
	public void saveBalanceByAcctID(long account_number, double amount);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update Customer_Details set amount =amount-?2 where account_number=?1",nativeQuery=true)
	public void withdrawAmount(long account_number, double amount);
	
}
