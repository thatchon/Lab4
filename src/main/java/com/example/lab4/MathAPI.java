package com.example.lab4;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public static double myPlus(@PathVariable("n1") double n1, @PathVariable("n2") double n2){
        return n1 + n2;
    }
    @RequestMapping(value = "/minus/{n1}/{n2}", method = RequestMethod.GET)
    public static double myMinus(@PathVariable("n1") double n1, @PathVariable("n2") double n2){
        return n1 - n2;
    }
    @RequestMapping(value = "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public static double myDivide(@PathVariable("n1") double n1, @PathVariable("n2") double n2){
        return n1 / n2;
    }
    @RequestMapping(value = "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public static double myMulti(@PathVariable("n1") double n1, @PathVariable("n2") double n2){
        return n1 * n2;
    }
    @RequestMapping(value = "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public static double myMod(@PathVariable("n1") double n1, @PathVariable("n2") double n2){
        return n1 % n2;
    }
    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public static double myMax(@RequestParam("n1") double n1, @RequestParam("n2") double n2){
        return Math.max(n1, n2);
    }
}
