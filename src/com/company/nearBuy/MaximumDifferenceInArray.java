package com.company.nearBuy;

import java.util.Arrays;

public class MaximumDifferenceInArray {

    public static void main(String[] args) {
        int arr[] = {7, 2, 3, 10, 2, 4, 8, 1};
        maximumDifference(arr);
    }

    private static int maximumDifference(int[] arr) {
        int maximumDifference;
        int rightMaximum[] = new int[arr.length];
        int leftMinimum[] = new int[arr.length];

        leftMinimum[0] = arr[0];
        for (int i = 1; i < arr.length; ++i)
            leftMinimum[i] = Math.min(arr[i], leftMinimum[i - 1]);
        rightMaximum[arr.length - 1] = arr[arr.length - 1];
        for (int j = arr.length - 2; j >= 0; --j)
            rightMaximum[j] = Math.max(arr[j], rightMaximum[j + 1]);

        maximumDifference = -1;
        int k =0,l = 0;
        while (k < arr.length && l < arr.length) {
//            maximumDifference = Math.max(maximumDifference,Math.abs(leftMinimum[i] - rightMaximum[j]));
            k++;
            l++;
        }

        return (maximumDifference==0)?-1:maximumDifference;
    }

}
