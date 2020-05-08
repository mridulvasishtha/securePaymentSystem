package com.springtransactions.demo.service;

import com.springtransactions.demo.model.Accountw;
import com.springtransactions.demo.repo.AccountwRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AnotherForAccountService {
    private final AccountwRepo accountwRepo;

    public AnotherForAccountService(AccountwRepo accountwRepo) {
        this.accountwRepo = accountwRepo;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void commitTxn(Integer id) {
        Accountw a = new Accountw(new Date());

        accountwRepo.save(a);
        if (false)
            throw new RuntimeException();

    }
}
