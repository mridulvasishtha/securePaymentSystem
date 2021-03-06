package com.springtransactions.demo.controller;


import com.springtransactions.demo.delete.MainEx;
import com.springtransactions.demo.exceptions.NotFoundException;
import com.springtransactions.demo.model.Account;
import com.springtransactions.demo.model.InitializePaymentRequestModel;
import com.springtransactions.demo.service.TransactionService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    private final TransactionService transactionService;
    @Autowired
    MainEx mainEx;

    public PaymentController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @ResponseBody
    @PostMapping(path = "/pay", consumes = "application/json", produces = "application/json")
    public String initializePayment(@RequestBody @NonNull InitializePaymentRequestModel initializePaymentRequestModel, @RequestParam(name = "id1", defaultValue = "0") Integer id1, @RequestParam(name = "id2", defaultValue = "0") Integer id2, @RequestParam(name = "balance", defaultValue = "0.0") Double balance) throws InterruptedException {
        return transactionService.initializeTransaction(initializePaymentRequestModel);
    }

    @ResponseBody
    @GetMapping(path = "/retrieve")
    public Account getAccount(@RequestParam(name = "name") String name, @RequestParam(name = "id") Integer id) throws NotFoundException {
        mainEx.callMe();
        return transactionService.getAccount(id, name);
    }
}