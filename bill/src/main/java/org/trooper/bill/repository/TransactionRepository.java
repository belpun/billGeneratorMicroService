package org.trooper.bill.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trooper.bill.entity.Transaction;
import org.trooper.bill.entity.TransactionPK;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, TransactionPK>{
	
	public List<Transaction> findById_CustomerIdAndId_TransactionDate(Long customerId, LocalDate transactionDate);

}
