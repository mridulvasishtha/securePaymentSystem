package com.springtransactions.demo.service;


import com.springtransactions.demo.model.Account;
import com.springtransactions.demo.model.InitializePaymentRequestModel;
import com.springtransactions.demo.repo.AccountsRepo;
import com.springtransactions.demo.transactionUtil.BalanceTransferUtil;
import com.springtransactions.demo.transactionUtil.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
//@Transactional
public class TransactionService {
    private final BalanceTransferUtil balanceTransferUtil;
    private final AccountsRepo accountsRepo;
    private final TransactionUtil transactionUtil;
    @Autowired
    @Qualifier("commonTransactionManager")
    PlatformTransactionManager transactionManager;

    public TransactionService(BalanceTransferUtil balanceTransferUtil, AccountsRepo accountsRepo, TransactionUtil transactionUtil) {
        this.balanceTransferUtil = balanceTransferUtil;
        this.accountsRepo = accountsRepo;
        this.transactionUtil = transactionUtil;
    }


    //
//    public static void main(String[] args) {
//        Random r=new Random();
//        System.out.println(r.nextInt(10));
//        System.out.println(Integer.parseInt((Math.random()*10)+""));
//    }
    //@Transactional(propagation = Propagation.REQUIRED)
    public String initializeTransaction(final InitializePaymentRequestModel request) throws InterruptedException {
        System.out.println("Hitted me");
        Set<Integer> ids = new HashSet<>();
        ids.add(request.getStaffId1());
        ids.add(request.getStaffId2());

        ///
        // List<Account> lst = new ArrayList<>();
        //System.out.println("Hit ONE");
        //Optional<Account> a1=accountsRepo.findById(3l);
        //System.out.println("Hit ONE"+" "+a1.get().getFirstName());
        //Optional<Account> a2=accountsRepo.findById(2l);
        //System.out.println("Hit TWO"+" "+a2.get().getFirstName());


        // TransactionDefinition def = new DefaultTransactionDefinition();
        //  TransactionStatus status = transactionManager.getTransaction(def);
        //  try {
        transactionUtil.registerTransaction(request.getStaffId1(), request.getStaffId2(), request.getAmount());
        Random r = new Random();
        //Thread.sleep(r.nextInt(10)*100);
        //  Thread.sleep(10000);
        balanceTransferUtil.commitTransaction(request, ids);
        //      transactionManager.commit(status);
        //  } catch (Exception e) {
        //      System.out.println("RollBack !!!");
        //      transactionManager.rollback(status);
        //  }
        // transactionUtil.registerTransaction(request.getStaffId1(), request.getStaffId2(), request.getAmount());
        // balanceTransferUtil.commitTransaction(request.getAmount(), dataMap.get(request.getStaffId1()), dataMap.get(request.getStaffId2()));
        if (false)
            throw new RuntimeException();
        return "Success !!!";
    }

    public Account getAccount(Integer id, String name) {
        Optional<Account> acc = accountsRepo.findById(Long.parseLong(id + ""));
        return acc.get();
    }
}