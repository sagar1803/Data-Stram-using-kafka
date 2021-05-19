package com.app.kafka.entity;

import java.util.Objects;
import javax.persistence.Column;


public class Stock {
	
	String stockName;
	
	Double stockPrice;
	public Stock() {
		super();
	}
	public Stock(String stockName, Double stockPrice) {
		super();
		this.stockName = stockName;
		this.stockPrice = stockPrice;
	}

	public String getStockName() {
		return stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public Double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}
	@Override
	public String toString() {
		return "Stock [ stockName=" + stockName + ", stockPrice=" + stockPrice + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(stockName, stockPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Stock)) {
			return false;
		}
		Stock other = (Stock) obj;
		return Objects.equals(stockName, other.stockName) && Objects.equals(stockPrice, other.stockPrice);
	}

	

}
