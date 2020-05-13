package com.springtransactions.demo.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecondComp {
    @Autowired
    FinalObjectComponent finalObjectComponent;
    public void getFinalObject() {
        System.out.println("Form second comp "+finalObjectComponent.toString());
    }
}
