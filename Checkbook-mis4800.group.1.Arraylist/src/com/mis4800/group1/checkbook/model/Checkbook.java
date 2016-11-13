package com.mis4800.group1.checkbook.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	/**
	 * Sort type is 0 for date 1 for amount 2 for payee default for memo 
	 * @param sortType
	 */
	public void sort(int sortType) {
		switch(sortType) {
		case 0: Collections.sort(transactions, new Comparator<Transaction>() {

			@Override
			public int compare(Transaction lhs, Transaction rhs) {
				// TODO Auto-generated method stub
				return lhs.compareByDate(rhs);
			}
		});
		break;
		
		case 1:
			Collections.sort(transactions, new Comparator<Transaction>() {

				@Override
				public int compare(Transaction lhs, Transaction rhs) {
					// TODO Auto-generated method stub
					return lhs.compareByAmount(rhs);
				}
			});
			break;
			
		case 2:
			Collections.sort(transactions, new Comparator<Transaction>() {

				@Override
				public int compare(Transaction lhs, Transaction rhs) {
					// TODO Auto-generated method stub
					return lhs.compareByPayee(rhs);
				}
			});
			break;
			
		default:
			Collections.sort(transactions, new Comparator<Transaction>() {

				@Override
				public int compare(Transaction lhs, Transaction rhs) {
					// TODO Auto-generated method stub
					return lhs.compareByMemo(rhs);
				}
			});
			break;
		}
	}

}
