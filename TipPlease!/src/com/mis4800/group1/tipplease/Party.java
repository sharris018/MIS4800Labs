package com.mis4800.group1.tipplease;

public class Party {
	
	private String partyname;
	private Double billAmount;
	private Double tipPercent;
	
	/**
	 * @param partyname
	 * @param billAmount
	 * @param tipPercent
	 */
	public Party(String partyname, Double billAmount, Double tipPercent) {
		super();
		this.partyname = partyname;
		this.billAmount = billAmount;
		this.tipPercent = tipPercent;
	}

	/**
	 * @return the partyname
	 */
	public String getPartyname() {
		return partyname;
	}

	/**
	 * @param partyname the partyname to set
	 */
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}

	/**
	 * @return the billAmount
	 */
	public Double getBillAmount() {
		return billAmount;
	}

	/**
	 * @param billAmount the billAmount to set
	 */
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	/**
	 * @return the tipPercent
	 */
	public Double getTipPercent() {
		return tipPercent;
	}

	/**
	 * @param tipPercent the tipPercent to set
	 */
	public void setTipPercent(Double tipPercent) {
		this.tipPercent = tipPercent;
	}

	public Double getTipAmount() {
		return billAmount * tipPercent / 100;
	} 
	public Double getTotalAmount() {
		return billAmount + getTipAmount();
	}
}
