package org.trooper.bill.entity;

import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Transaction {

	@EmbeddedId
	private TransactionPK id;

	private int quantity;
	private double itemPrice;
	
	public Transaction(Long customerId, Long itemId, int quantity,
			LocalDate transactionDate, double itemPrice) {
		super();
		this.id = new TransactionPK(customerId, transactionDate, itemId);
		this.quantity = quantity;
		this.itemPrice = itemPrice;
	}
	
	public Transaction() {
		
	}
	public TransactionPK getId() {
		return id;
	}

	public void setId(TransactionPK id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
}
