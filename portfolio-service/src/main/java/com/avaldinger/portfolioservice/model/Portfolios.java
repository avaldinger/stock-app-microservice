package com.avaldinger.portfolioservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="portfolios")
public class Portfolios {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="ticker")
	private String ticker;
	@Column(name="amount")
	private int amount;
	@Column(name="fk_account_id_portfolios")
	private int accountId;

	
	
	
	public Portfolios() {}

	public Portfolios(String ticker, int amount, int accountId) {
		this.ticker = ticker;
		this.amount = amount;
		this.accountId = accountId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Portfolios: id=" + id + ", ticker=" + ticker + ", amount=" + amount;
	}

}
