package org.trooper.bill.service.api;

import java.time.LocalDate;

import org.trooper.bill.entity.Bill;

public interface BillService {
	public Bill getBill(Long customerId, LocalDate transactionDate);
}
