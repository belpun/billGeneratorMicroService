package org.trooper.bill.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Bill {
	
	private Customer customer;
	private LocalDate transactionDate;
	
	private Map<Long, Item> items;
	
	private List<Transaction> transactions;
	
	public Bill() {
	}
	
	public Bill(Customer customer, LocalDate transactionDate, Map<Long, Item> items, List<Transaction> transactions) {
		super();
		this.customer = customer;
		this.transactionDate = transactionDate;
		this.items = items;
		this.transactions = transactions;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public double getTotal () {
		return this.transactions.stream().mapToDouble(transaction -> transaction.getQuantity() * transaction.getItemPrice()).sum();
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Map<Long, Item> getItems() {
		return items;
	}

	public void setItems(Map<Long, Item> items) {
		this.items = items;
	}
	

	public String printBill() {
		StringBuilder report = new StringBuilder();
		report.append("Bill for date : " + transactionDate + " \n");
		this.transactions.forEach(transaction -> {
			Item item = items.get(transaction.getId().getItemId());
			report.append(item.getName() + "    " + transaction.getItemPrice() + "    " + transaction.getQuantity()
			+ "    " +  transaction.getItemPrice() * transaction.getQuantity() + "\n");
		});
		
		report.append("Grand Total : " + getTotal());
		System.out.println(report.toString());
		return report.toString();
		
	}
}
