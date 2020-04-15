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
import org.trooper.bill.service.api.CustomerService;
import org.trooper.bill.service.api.ItemService;
@Service
public class DefaultBillService implements BillService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private ItemService itemService;
	
	
	public Bill getBill(Long customerId, LocalDate transactionDate) {
		
		Customer customer = customerService.getCustomer(customerId);
		
		List<Transaction> transactions = this.transactionRepository.findById_CustomerIdAndId_TransactionDate(customerId, transactionDate);
		
		
		Map<Long, Item> items = transactions.stream()
		.map(transaction -> 
		  		this.itemService.getItem(transaction.getId().getItemId())
			).collect(Collectors.toMap(Item::getId, item -> item));
		
		Bill bill = new Bill(customer, transactionDate, items, transactions);
		return bill;
		
	}
	
}
