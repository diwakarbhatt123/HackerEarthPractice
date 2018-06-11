package com.company.nearBuy;

public class CountDuplicates {
    public static void main(String[] args) {
        int arr[] = {1,2,2,3,3,3};
        System.out.println(findDuplicates(arr));
    }

    private static int findDuplicates(int[] arr) {
        int duplicateCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i]%arr.length;
            arr[index] += arr.length;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]/arr.length > 1){
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
}
