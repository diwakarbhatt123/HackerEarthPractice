package com.company.arrays;

public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.doSomething();
    }


    public String dummyMethod(){
        try {
            return "try";
        }catch (Exception e){
            return "catch";
        }finally {
            return "finally";
        }
    }
}
