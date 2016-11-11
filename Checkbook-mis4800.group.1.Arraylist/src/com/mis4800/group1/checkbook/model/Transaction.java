package com.mis4800.group1.checkbook.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transaction {

	private Date tdate;
	private String payee;
	private Double amount;
	private String memo;

	private static SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
	private static NumberFormat currencyformat = NumberFormat.getCurrencyInstance(Locale.getDefault());

	/**
	 * @param tdate
	 * @param payee
	 * @param amount
	 * @param memo
	 */
	public Transaction(Date tdate, String payee, Double amount, String memo) {
		super();
		this.tdate = tdate;
		this.payee = payee;
		this.amount = amount;
		this.memo = memo;
	}

	public Transaction(String payee, Double amount, String memo) {
		this(new Date(), payee, amount, memo);
	}

	/**
	 * @return the tdate
	 */
	public Date getTdate() {
		return tdate;
	}

	/**
	 * @param tdate
	 *            the tdate to set
	 */
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	/**
	 * @return the payee
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * @param payee
	 *            the payee to set
	 */
	public void setPayee(String payee) {
		this.payee = payee;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDateString() {
		return dateformat.format(tdate);
	}

	public String getFormattedAmount() {
		return currencyformat.format(amount);

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " Payee: " + getPayee() + "\n Memo: " + getMemo() + "\n Date: " + getDateString()
				+ "\n Amount: " + getFormattedAmount() + "";
	}

}
