package com.springtransactions.demo.decorators;


import com.springtransactions.demo.model.Account;

public class AccountDecorator<T extends Account> {
private final T account;
    public AccountDecorator(T account) {
        this.account = account;
    }

    public void balanceDebit(Double debitAmount){
        if(account.getBalance()-debitAmount<0){
            throw new RuntimeException("Out of money");
        }
        account.setBalance(account.getBalance()-debitAmount);
    }

    public void balanceCredit(Double creditAmount){
        account.setBalance(account.getBalance()+creditAmount);
    }
}
