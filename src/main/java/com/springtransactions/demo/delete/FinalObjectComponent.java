package com.springtransactions.demo.delete;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FinalObjectComponent {
    String name;

    public FinalObjectComponent(String d) {
        name = d;
        System.out.println("@@@@@@@Object created !!!");
    }

}
