package com.app.kafka.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

@Entity
public class TickEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long tickEventId;
	@Valid
	@Embedded
	
	Stock stock ;
	public TickEvent(Long tickEventId, Stock stock) {
		super();
		this.tickEventId = tickEventId;
		this.stock = stock;
	}
	public TickEvent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getTickEventId() {
		return tickEventId;
	}
	public void setTickEventId(Long tickEventId) {
		this.tickEventId = tickEventId;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "TickEvent [tickEventId=" + tickEventId + ", stock=" + stock + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(stock, tickEventId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TickEvent)) {
			return false;
		}
		TickEvent other = (TickEvent) obj;
		return Objects.equals(stock, other.stock) && Objects.equals(tickEventId, other.tickEventId);
	}
	
	
	
	

}
