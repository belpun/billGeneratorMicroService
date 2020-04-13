package org.trooper.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trooper.dao.api.ItemDao;
import org.trooper.entity.Item;
import org.trooper.service.api.ItemService;

@Service
public class DefaultItemService implements ItemService {
	
	@Autowired(required = false)
	private ItemDao itemDao;
	
	@Override
	public Item getItem(Long itemId) {
		return this.itemDao.getOne(itemId);
	}

}
