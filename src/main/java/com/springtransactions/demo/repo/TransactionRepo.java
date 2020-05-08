package com.springtransactions.demo.repo;

import com.springtransactions.demo.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions, Long> {
}
