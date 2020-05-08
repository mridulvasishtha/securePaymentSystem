package com.springtransactions.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Account")
@NoArgsConstructor
public class Account extends Staff {

    @NonNull
    @Column(name = "balance")
    private Double balance;

    public Account(String phoneNumber,String firstName,String lastName,Integer staffId,Double balance) {
        this.balance = balance;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setStaffId(staffId);
        this.setPhoneNumber(phoneNumber);
    }

    @Override
    public String toString() {
        return "Account{Staff id "+getStaffId()+" " +
                "balance=" + balance +
                '}';
    }
}