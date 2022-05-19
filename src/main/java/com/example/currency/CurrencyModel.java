package com.example.currency;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="customer_details")
public class CurrencyModel {
	@Id
	@Column(name="account_number")
	private long  account_number;
	@Column(name="asset_type")
	private String asset_type;
	@Column(name="amount")
	private double amount;
	@Transient
	private long  destaccount_number;
	public long getaccount_number() {
		return account_number;
	}
	public void setaccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getAsset_type() {
		return asset_type;
	}
	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getDestaccount_number() {
		return destaccount_number;
	}
	public void setDestaccount_number(long destaccount_number) {
		this.destaccount_number = destaccount_number;
	}
	public CurrencyModel(long account_number, String asset_type, double amount, long destaccount_number) {
		super();
		this.account_number = account_number;
		this.asset_type = asset_type;
		this.amount = amount;
		this.destaccount_number = destaccount_number;
	}
	public CurrencyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CurrencyModel [account_number=" + account_number + ", asset_type=" + asset_type + ", amount=" + amount
				+ ", destaccount_number=" + destaccount_number + "]";
	}

	

}
