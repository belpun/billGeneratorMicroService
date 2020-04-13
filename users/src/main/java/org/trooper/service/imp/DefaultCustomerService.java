package org.trooper.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trooper.dao.api.CustomerRepository;
import org.trooper.entity.Customer;
import org.trooper.service.api.CustomerService;

@Service
public class DefaultCustomerService implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public Optional<Customer> findCustomer(Long customerId) {
		return this.customerRepo.findById(customerId);
	}

}
