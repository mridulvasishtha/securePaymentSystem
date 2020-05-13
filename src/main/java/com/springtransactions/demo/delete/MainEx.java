package com.springtransactions.demo.delete;

import org.springframework.stereotype.Component;

@Component
public class MainEx {
    FirstComp firstComp;
    SecondComp secondComp;

    public MainEx(FirstComp firstComp, SecondComp secondComp) {
        this.firstComp = firstComp;
        this.secondComp = secondComp;
    }

    public void callMe(){
        firstComp.getFinalObject();
        secondComp.getFinalObject();
    }
}
