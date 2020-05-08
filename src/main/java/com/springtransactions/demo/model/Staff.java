package com.springtransactions.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@MappedSuperclass
@Getter
@Setter
public class Staff extends Person {
    @Column(name="staff_Id")
    private Integer staffId;
}
