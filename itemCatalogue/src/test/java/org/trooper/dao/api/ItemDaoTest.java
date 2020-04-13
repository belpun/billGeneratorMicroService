package org.trooper.dao.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.trooper.bootstrap.ItemCatalogueApplication;
import org.trooper.entity.Item;

@DataJpaTest
@SpringBootTest(classes = ItemCatalogueApplication.class)
class ItemDaoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ItemDao repository;

	@Test
	public void testFindByLastName() {
		Item bread = new Item(10l, "bread", 2.3);
		entityManager.persist(bread);

		List<Item> findByLastName = repository.findByName(bread.getName());

		assertThat(findByLastName).extracting(Item::getName).containsOnly(bread.getName());
	}

}
