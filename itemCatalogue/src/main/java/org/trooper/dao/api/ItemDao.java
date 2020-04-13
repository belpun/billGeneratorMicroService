package org.trooper.dao.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trooper.entity.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {
	
	List<Item> findByName(String name);
}
