package org.trooper.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trooper.entity.Customer;
import org.trooper.service.api.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/{customerId}")
	public Customer getCustomer(@PathVariable Long customerId) {
		return customerService.findCustomer(customerId)
				.orElseThrow(() -> new RuntimeException("Cannot find the customer"));
	}
	
	@GetMapping(value = "test")
	public String test() {
		return "test passed";
	}
}
