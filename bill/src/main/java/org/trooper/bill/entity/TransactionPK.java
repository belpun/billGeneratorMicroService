package org.trooper.bill.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class TransactionPK implements Serializable{

	private static final long serialVersionUID = 7307169076641761417L;
	private Long customerId;
	private LocalDate transactionDate;
	private Long itemId;
	
	public TransactionPK(Long customerId, LocalDate transactionDate, Long itemId) {
		super();
		this.customerId = customerId;
		this.transactionDate = transactionDate;
		this.itemId = itemId;
	}
	
	public TransactionPK() {
		
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
}
