package com.springtransactions.demo.service;

import com.springtransactions.demo.model.Transactionw;
import com.springtransactions.demo.repo.TransactionwRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class AnotherService {
    private final TransactionwRepo transactionwRepo;

    public AnotherService(TransactionwRepo transactionwRepo) {
        this.transactionwRepo = transactionwRepo;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void commitTxn(Integer id) {
        Transactionw t = new Transactionw(new Date());
        Optional<Transactionw> t2 = transactionwRepo.findById(1l);
        Transactionw t22 = t2.get();
        t22.setDate(new Date());
        Transactionw t1 = transactionwRepo.save(t22);
        if (false) {
            throw new RuntimeException();
        }
    }
}
