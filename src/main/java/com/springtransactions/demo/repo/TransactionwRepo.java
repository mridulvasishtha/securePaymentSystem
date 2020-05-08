package com.springtransactions.demo.repo;

import com.springtransactions.demo.model.Transactionw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionwRepo extends JpaRepository<Transactionw,Long> {
}
