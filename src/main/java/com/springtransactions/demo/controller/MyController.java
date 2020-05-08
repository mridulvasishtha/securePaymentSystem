package com.springtransactions.demo.controller;

import com.springtransactions.demo.service.TransactionwService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class MyController {
    private final TransactionwService transactionService;

    public MyController(TransactionwService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(path = "/commitTxn/{id}")
    public void testTransaction(@PathParam(value = "id")Integer id){
        transactionService.testTransactions(id);
    }
}
