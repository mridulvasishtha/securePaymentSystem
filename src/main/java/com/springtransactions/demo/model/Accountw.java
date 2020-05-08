package com.springtransactions.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="accountw")
public class Accountw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="account")
    private Date date;

    public Accountw(Date date) {
        this.date = date;
    }
}
