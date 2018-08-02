package com.company.goldman;

import java.util.ArrayList;
import java.util.List;

public class SpecialElement {

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        findSpecialElement(matrix);
    }

    private static void findSpecialElement(List<List<Integer>> matrix) {
        List<Integer> specialElementList = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            findMaxMinInColumn(matrix,specialElementList);
        }
    }

    private static void findMaxMinInColumn(List<List<Integer>> matrix, List<Integer> specialElementList) {
        int maxCol = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.size(); i++) {
            int maxRow = Integer.MIN_VALUE;
            int minRow = Integer.MAX_VALUE;
            List<Integer> currRow = matrix.get(i);
            for (int j = 0; j < currRow.size(); j++) {
                int currVal = currRow.get(j);
                if (currVal > maxRow) {
                    maxRow = currVal;
                } else if (currVal < minRow) {
                    minRow = currVal;
                }
            }
            specialElementList.add(maxRow);
            specialElementList.add(minRow);
        }
    }

}
