package com.mycompany.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyMain {
    private static final Logger Log= LoggerFactory.getLogger(MyMain.class);
    public static void main(String[]args){
     Log.warn("i am a warning");
     Log.info("i am an info");
     Log.error("i am an error");

    }
}
