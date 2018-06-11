package com.company;

import java.util.stream.IntStream;

public class AllEvenNumberInBinary {

    public static void main(String[] args) {
        IntStream.range(1,5000000).filter(num -> (num%2==0 && canBeReducedToZero(num))).forEach(num -> {
            System.out.println(num + " " +Integer.toBinaryString(num));
        });
//        System.out.println(IntStream.rangeClosed(10000,99999).count());
    }

    private static boolean canBeReducedToZero(int val) {
        int v=val;
        while (val != 1) {
            if (val % 2 != 0) {
                return false;
            } else {
                val = val / 2;
            }
        }
        return true;
    }

}
