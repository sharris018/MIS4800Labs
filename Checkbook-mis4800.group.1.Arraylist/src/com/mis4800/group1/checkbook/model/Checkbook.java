package com.mis4800.group1.checkbook.model;

import java.util.ArrayList;
import java.util.List;

public class Checkbook {
	
	private String bank;
	private String owner;
	
	private List<Transaction> transactions;

	/**
	 * @param bank
	 * @param owner
	 */
	public Checkbook(String bank, String owner) {
		super();
		this.bank = bank;
		this.owner = owner;
		this.transactions = new ArrayList<Transaction>();
	}

	public void addTransaction(Transaction newt) {
		transactions.add(newt);
		
	}
	
	public void deleteTransaction(int position) {
		transactions.remove(position);
		
	}
	
	public void updateTransaction(int position, Transaction newt) {
		transactions.set(position, newt);
	}
	
	public Double balance() {
		Double sum = 0.0; 
		for (Transaction thistransaction : transactions) {
			sum = sum + thistransaction.getAmount();
		}
		return sum; 
	}
	
 	/**
	 * @return the transactions
	 */
	public List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

}
