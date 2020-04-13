package org.trooper.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trooper.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
