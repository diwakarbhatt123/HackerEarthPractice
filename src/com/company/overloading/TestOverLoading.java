package com.company.overloading;

public class TestOverLoading {

    public static String doStatic(){
        return "Fuck You in static";
    }

    public void doSomething(Integer i){
        System.out.println("Wrapper int called");
    }

    public void doSomething(int i){
        System.out.println("Primitive int called");
    }

    public void doNothing(){
        System.out.println("H" + "I");
        System.out.println('h'+'i');
    }

    public static void main(String[] args) {
        TestOverLoading testOverLoading = new TestOverLoading();
        testOverLoading.doSomething(1);
        testOverLoading.doNothing();
    }

}
