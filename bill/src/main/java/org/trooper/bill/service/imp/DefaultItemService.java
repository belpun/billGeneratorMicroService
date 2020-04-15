package org.trooper.bill.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.trooper.bill.entity.Item;
import org.trooper.bill.service.api.ItemService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class DefaultItemService implements ItemService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(fallbackMethod = "fallBackGetItem",
	commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"), 
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"), 
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
			})
	public Item getItem(Long itemId) {
		return this.restTemplate.getForObject("http://item-catalogue-service/item/" + itemId, Item.class);
	}
	
	public Item fallBackGetItem(Long itemId) {
		return new Item(System.currentTimeMillis(),"defaultItem"  , 1);
	}

}
