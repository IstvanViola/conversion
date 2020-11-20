package com.viola.model;

import javax.persistence.*;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//represents a table in mySql database

@Entity
@Table(name = "rates")
public class GetRates {
	
	@Id
	@JoinColumn(name = "id")
	private int id;
	
	@NonNull
    @JoinColumn(name = "currency")
	private String currency;
	
	
	@NonNull
    @JoinColumn(name = "buy")
	private int buy;
	
	@NonNull
    @JoinColumn(name = "sell")
	private int sell;
	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getBuy() {
		return buy;
	}

	public void setBuy(int buy) {
		this.buy = buy;
	}

	public int getSell() {
		return sell;
	}

	public void setSell(int sell) {
		this.sell = sell;
	}


	public GetRates(int id, String currency, int buy, int sell) {
		this.id = id;
		this.currency = currency;
		this.buy = buy;
		this.sell = sell;
	}

}