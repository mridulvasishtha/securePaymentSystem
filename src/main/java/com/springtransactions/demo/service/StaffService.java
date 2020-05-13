package com.springtransactions.demo.service;

import com.springtransactions.demo.model.Account;
import com.springtransactions.demo.model.AddStaffRequestModel;
import com.springtransactions.demo.repo.AccountsRepo;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    private final AccountsRepo accountsRepo;

    public StaffService(AccountsRepo accountsRepo) {
        this.accountsRepo = accountsRepo;
    }
    public String addStaff(AddStaffRequestModel addStaffRequestModel){
        return accountsRepo.save(new Account(addStaffRequestModel.getPhoneNumber(),addStaffRequestModel.getFirstName(),
                addStaffRequestModel.getLastName(),addStaffRequestModel.getStaffId(),addStaffRequestModel.getBalance())).toString();
    }
}
