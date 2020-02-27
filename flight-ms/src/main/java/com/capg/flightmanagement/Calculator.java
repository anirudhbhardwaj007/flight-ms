package com.mycompany.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    private static final Logger Log = LoggerFactory.getLogger("Calculator");

    public int add(int a, int b) {
        System.out.println("inside add2222222");
        int c = a + b;
        return c;
    }


}
