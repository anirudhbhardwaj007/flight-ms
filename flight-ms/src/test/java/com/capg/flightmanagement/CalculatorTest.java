package com.mycompany.app;

import org.junit.jupiter.api.*;

public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    public static void start() {
        System.out.println("inside startInit");
    }

    @AfterAll
    public static void end() {
        System.out.println("inside end");
    }

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
        System.out.println("inside setup");
    }

    @AfterEach
    public void clear() {
        calculator = null;
        System.out.println("inside clear");
    }


    @Test
    public void testAdd_1() {
        System.out.println("inside testadd_1");
        int result = calculator.add(2, 3);
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testAdd_2() {
        System.out.println("inside testadd_2");
        int result = calculator.add(-2, -3);
        Assertions.assertEquals(-5, result);
    }

        /*
        @Test
        @Disabled
        public void testIsEven_1(){
            System.out.println("inside testIsEven_1");
             boolean result= c.isEven(10);
             Assertions.assertTrue(result);
        }
        @Test
        @Disabled
        public void testIsEven_2(){
            System.out.println("inside testIsEven_1");
            boolean result= c.isEven(9);
            Assertions.assertFalse(result);
        }


       @ParameterizedTest
       @ValueSource(ints = {1,2,3,4})
        public void testIsEven_1(int num){
           System.out.println("inside testIsEven_1");
           boolean result= c.isEven(num);
           boolean expected=num%2==0;
           Assertions.assertEquals(expected,result);

       }
    */

}
