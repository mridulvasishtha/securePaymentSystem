package com.springtransactions.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name="transactionW")
@NoArgsConstructor
public class Transactionw {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @Column(name="date")
    private Date date;

    public Transactionw(Date date) {
        this.date = date;
    }
}
