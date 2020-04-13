package org.trooper.service.api;

import java.util.Optional;

import org.trooper.entity.Customer;

public interface CustomerService {
	
	public Optional<Customer> findCustomer(Long customerId);

}
