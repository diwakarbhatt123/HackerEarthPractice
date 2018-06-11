package com.company.arrays;

public interface Test1 {

    String CONST_STRING = "Dummy";

    void doSomething();

    default boolean equals(){
        return false;
    }

    static boolean isNull(){
        return false;
    }
}
