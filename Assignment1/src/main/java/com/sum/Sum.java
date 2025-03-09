package com.sum;

import org.springframework.stereotype.Component;

@Component
public class Sum {

    public int computeSum(){
        int a = 10;
        int b = 11;
        int sum = a+b;
        System.out.println("SUM of " + a + " " + b + " is "+sum);
        return sum;
    }


}
