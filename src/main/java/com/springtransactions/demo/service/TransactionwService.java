package com.springtransactions.demo.service;

import com.springtransactions.demo.model.Accountw;
import com.springtransactions.demo.repo.AccountwRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransactionwService {
    private final AnotherService anotherService;
    private final AnotherForAccountService anotherForAccountService;
    private final AccountwRepo accountwRepo;
    @Autowired
    PlatformTransactionManager transactionManager;

    public TransactionwService(AnotherService anotherService, AnotherForAccountService anotherForAccountService, AccountwRepo accountwRepo) {
        this.anotherService = anotherService;
        this.anotherForAccountService = anotherForAccountService;
        this.accountwRepo = accountwRepo;
    }
    @Transactional
    public void testTransactions(final Integer id) {
       // TransactionDefinition def = new DefaultTransactionDefinition();
       // TransactionStatus status = transactionManager.getTransaction(def);
        try {
           // commitTxn();  //proof that transactional do not work in same directory
            anotherService.commitTxn(id);
             anotherForAccountService.commitTxn(id);
          //  transactionManager.commit(status);
        } catch (Exception e) {
         //   transactionManager.rollback(status);
            System.out.println("Rolled back");
        }

    }
    @Transactional
    public void commitTxn(){
        Accountw a = new Accountw(new Date());
        accountwRepo.save(a);
        if(true){
            throw new RuntimeException();
        }
    }
}
