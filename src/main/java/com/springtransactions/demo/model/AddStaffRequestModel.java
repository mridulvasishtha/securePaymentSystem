package com.springtransactions.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddStaffRequestModel {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer staffId;
    private Double balance;

    public AddStaffRequestModel(String firstName, String lastName, String phoneNumber, Integer staffId, Double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.staffId = staffId;
        this.balance = balance;
    }
}
