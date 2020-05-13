package com.springtransactions.demo.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class FirstComp {
    @Autowired
    FinalObjectComponent finalObjectComponent;

    public void getFinalObject() {
        System.out.println("Form first comp "+finalObjectComponent.toString()+" name ");
    }
}
