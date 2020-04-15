package org.trooper.bill.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.trooper.bill.entity.Customer;
import org.trooper.bill.service.api.CustomerService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class DefaultCustomerService implements CustomerService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@HystrixCommand(fallbackMethod = "fallBackGetCustomer",
	commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"), 
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), 
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
			})
	public Customer getCustomer(Long customerId) {
		return this.restTemplate.getForObject("http://customer-info-service/customer/" + customerId, Customer.class);
	}
	
	public Customer fallBackGetCustomer(Long customerId) {
		return new Customer(1000l, "default firstName", "default lastName");
	}
}
