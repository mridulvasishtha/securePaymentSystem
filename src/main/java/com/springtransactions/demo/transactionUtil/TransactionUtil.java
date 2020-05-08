package com.springtransactions.demo.transactionUtil;


import com.springtransactions.demo.model.Transactions;
import com.springtransactions.demo.repo.AccountsRepo;
import com.springtransactions.demo.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class TransactionUtil {
    private final TransactionRepo transactionRepo;
    private final AccountsRepo accountsRepo;


    public TransactionUtil(TransactionRepo transactionRepo, AccountsRepo accountsRepo) {
        this.transactionRepo = transactionRepo;
        this.accountsRepo = accountsRepo;
    }

    // @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = RuntimeException.class)
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean  registerTransaction(Integer staffId1, Integer staffId2, Double amount) {
        Transactions t1 = new Transactions(new Date(), amount, staffId1, staffId2);
        transactionRepo.save(t1);

        if (false)
            throw new RuntimeException();
        return true;
    }
}