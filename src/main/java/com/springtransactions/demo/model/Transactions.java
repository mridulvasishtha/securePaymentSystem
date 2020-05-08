package com.springtransactions.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="transactions")
@Getter
@Setter
@NoArgsConstructor
public class Transactions extends BaseEntity{
    @Column(name="txn_time")
    private Date txnTime;

    @Column(name="debit_amount")
    private Double debitAmount;
    @Column(name="from_staff_id")
    private Integer fromStaffId;
    @Column(name="to_staff_id")
    private Integer toStaffId;

    public Transactions(Date txnTime, Double debitAmount, Integer fromDebitStaffId, Integer toCreditStaffId) {
        this.txnTime = txnTime;
        this.debitAmount = debitAmount;
        this.fromStaffId = fromDebitStaffId;
        this.toStaffId = toCreditStaffId;
    }
}
