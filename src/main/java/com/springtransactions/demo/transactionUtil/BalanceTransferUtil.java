package com.springtransactions.demo.transactionUtil;

import com.springtransactions.demo.decorators.AccountDecorator;
import com.springtransactions.demo.model.Account;
import com.springtransactions.demo.model.InitializePaymentRequestModel;
import com.springtransactions.demo.model.Transactions;
import com.springtransactions.demo.repo.AccountsRepo;
import com.springtransactions.demo.repo.TransactionRepo;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Component
public class BalanceTransferUtil {
    static Semaphore lk = new Semaphore(1);
    private final AccountsRepo accountsRepo;
    private final TransactionRepo transactionRepo;
    Lock ls = new ReentrantLock();

    public BalanceTransferUtil(AccountsRepo accountsRepo, TransactionRepo transactionRepo) {
        this.accountsRepo = accountsRepo;
        this.transactionRepo = transactionRepo;
    }

    //@Transactional
    public void commitTransaction(InitializePaymentRequestModel request, Set ids) throws InterruptedException {
        boolean txnDone = false;
        while (!txnDone) {
            if (lk.availablePermits() > 0 && lk.tryAcquire()) {
                try {
                    //boolean mystatus = lk.tryAcquire();
                    System.out.println("Status : + mystatus +  Locked " + Thread.currentThread().getId() + " lock status" + lk.availablePermits());
                    List<Account> list = accountsRepo.findByStaffIdIn(ids);
                    Map<Integer, Account> dataMap = list.stream().collect(Collectors.toMap(obj -> obj.getStaffId(), obj -> obj));
                    System.out.println(dataMap + " ##");
                    Account fromDebit = dataMap.get(request.getStaffId1());
                    Account toCredit = dataMap.get(request.getStaffId2());
                    Double amount = request.getAmount();
                    AccountDecorator adDebit = new AccountDecorator(fromDebit);
                    AccountDecorator adCredit = new AccountDecorator(toCredit);
                    System.out.println(" v dv" + lk.availablePermits());

                    adDebit.balanceDebit(amount);
                    adCredit.balanceCredit(amount);
                    List<Account> lst = new ArrayList<>();
                    lst.add(fromDebit);
                    lst.add(toCredit);
                    accountsRepo.saveAll(lst);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    txnDone = true;
                    lk.release();
                    System.out.println("UnLocked " + Thread.currentThread().getId() + " av permit " + lk.availablePermits());
                }
            } else {
                System.out.println("waiting as lock not possessed as av permit " + lk.availablePermits());
                // Thread.sleep(1000);
            }
        }
        if (false) {
            throw new RuntimeException();
        }
//        System.out.println("Successful transfer from " + fromDebit.getStaffId()
//                + "_" + fromDebit.getFirstName() + " -> " + toCredit.getStaffId() + "_" + toCredit.getFirstName());
    }

    //@Transactional
    public void commitTransactionNoLock(InitializePaymentRequestModel request, Set ids) throws InterruptedException {
        boolean txnDone = false;
        // while (!txnDone) {
        //  if (lk.availablePermits() > 0 && lk.tryAcquire()) {
        try {
            //boolean mystatus = lk.tryAcquire();
            System.out.println("Status : + mystatus +  Locked " + Thread.currentThread().getId() + " lock status" + lk.availablePermits());
            List<Account> list = accountsRepo.findByStaffIdIn(ids);
            Map<Integer, Account> dataMap = list.stream().collect(Collectors.toMap(obj -> obj.getStaffId(), obj -> obj));
            System.out.println(dataMap + " ##");
            Account fromDebit = dataMap.get(request.getStaffId1());
            Account toCredit = dataMap.get(request.getStaffId2());
            Double amount = request.getAmount();
            AccountDecorator adDebit = new AccountDecorator(fromDebit);
            AccountDecorator adCredit = new AccountDecorator(toCredit);
            //         System.out.println(" v dv" + lk.availablePermits());

            adDebit.balanceDebit(amount);
            adCredit.balanceCredit(amount);
            List<Account> lst = new ArrayList<>();
            lst.add(fromDebit);
            lst.add(toCredit);
            accountsRepo.saveAll(lst);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //   txnDone = true;
            //        lk.release();
            System.out.println("UnLocked " + Thread.currentThread().getId() + " av permit " + lk.availablePermits());
        }
        //    }
        //else {
        //   System.out.println("waiting as lock not possessed as av permit " + lk.availablePermits());
        // Thread.sleep(1000);
        //}
        //  }
        if (false) {
            throw new RuntimeException();
        }
//        System.out.println("Successful transfer from " + fromDebit.getStaffId()
//                + "_" + fromDebit.getFirstName() + " -> " + toCredit.getStaffId() + "_" + toCredit.getFirstName());
    }



    //@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
    public boolean registerTransaction(Integer staffId1, Integer staffId2, Double amount) {
        transactionRepo.save(new Transactions(new Date(), amount, staffId1, staffId2));
        if (false)
            throw new RuntimeException();
        return true;
    }
}