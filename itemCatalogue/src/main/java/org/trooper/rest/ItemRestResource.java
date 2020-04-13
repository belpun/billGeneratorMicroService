package org.trooper.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trooper.entity.Item;
import org.trooper.service.api.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemRestResource {
	
	@Autowired
	private ItemService itemService;

	@GetMapping(value = "/{itemId}")
	public Item getItem(@PathVariable Long itemId) {
		
		return itemService.getItem(itemId);
				//.orElseThrow(() -> new RuntimeException("cannot find the item"));
	}

}
