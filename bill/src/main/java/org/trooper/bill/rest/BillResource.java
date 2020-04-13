package org.trooper.bill.rest;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trooper.bill.entity.Bill;
import org.trooper.bill.service.api.BillService;

@RestController
@RequestMapping(value = "bill")
public class BillResource {
	
	@Autowired
	private BillService billService;
	
	@GetMapping("/customer/{customerId}/transactionDate/{transactionDate}")
	public String getBill(@PathVariable Long customerId, 
			@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate transactionDate) {
		Bill bill = billService.getBill(customerId, transactionDate);
		
		return bill.printBill();
	}

}
