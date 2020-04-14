package org.trooper.bill.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.trooper.bill.entity.Bill;
import org.trooper.bill.entity.Customer;
import org.trooper.bill.entity.Item;
import org.trooper.bill.entity.Transaction;
import org.trooper.bill.repository.TransactionRepository;
import org.trooper.bill.service.api.BillService;
@Service
public class DefaultBillService implements BillService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Bill getBill(Long customerId, LocalDate transactionDate) {
		
		Customer customer = this.restTemplate.getForObject("http://customer-info-service/customer/" + customerId, Customer.class);
		System.out.println(customer);
		List<Transaction> transactions = this.transactionRepository.findById_CustomerIdAndId_TransactionDate(customerId, transactionDate);
		
		
		Map<Long, Item> items = transactions.stream()
		.map(transaction -> 
			this.restTemplate.getForObject("http://item-catalogue-service/item/" + transaction.getId().getItemId(), Item.class)
			).collect(Collectors.toMap(Item::getId, item -> item));
		
		Bill bill = new Bill(customer, transactionDate, items, transactions);
		return bill;
		
	}
	
}
