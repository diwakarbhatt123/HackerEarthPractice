package com.company.arrays;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestClass implements Test1,Test2 {

    @Override
    public void doSomething() {
        Runnable runnable = () -> System.out.println("Do something");
        Arrays.asList(1,2,3,44).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

            }
        });
        System.out.println("Did Something");
    }

    public static void main(String[] args) {
        String a = "abc";
        Class<String> stringClass = (Class<String>) a.getClass();
        stringClass.getMethods()[0].getName();
        DateTimeFormatter.ofPattern("dd-mm-yyyy");
        a.getClass();
        List<String> strings = new ArrayList<>();
//        strings.parallelStream().flatMap(List::stream);
        strings.parallelStream().map(string -> string.concat("abc"));
    }
}
