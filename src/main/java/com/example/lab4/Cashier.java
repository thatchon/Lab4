package com.example.lab4;

import org.springframework.web.bind.annotation.*;

@RestController
public class Cashier {
    private Change change = new Change();

    @RequestMapping(value = "/getChange/{amount}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("amount") int amount){
        change.setB1000(0);
        change.setB500(0);
        change.setB100(0);
        change.setB20(0);
        change.setB10(0);
        change.setB5(0);
        change.setB1(0);
        if(amount >= 1000){
            change.setB1000(amount/1000);
            amount = amount%1000;
        } if(amount >= 500){
            change.setB500(amount/500);
            amount = amount%500;
        } if(amount >= 100){
            change.setB100(amount/100);
            amount = amount%100;
        } if(amount >= 20){
            change.setB20(amount/20);
            amount = amount%20;
        } if(amount >= 10){
            change.setB10(amount/10);
            amount = amount%10;
        } if(amount >= 5){
            change.setB5(amount/5);
            amount = amount%5;
        } if(amount >= 1){
            change.setB1(amount);
            amount = 0;
        }
        return change;
    }
}