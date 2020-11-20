package com.viola.model;

import javax.persistence.Entity;

@Entity
public class Conversion {
	
	private String convertFrom;
	
	private int convertTo;
	
	private int amount;

	public String getConvertFrom() {
		return convertFrom;
	}

	public void setConvertFrom(String convertFrom) {
		this.convertFrom = convertFrom;
	}

	public int getConvertTo() {
		return convertTo;
	}

	public void setConvertTo(int convertTo) {
		this.convertTo = convertTo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
