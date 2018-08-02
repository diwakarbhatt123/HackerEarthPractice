package com.company.goldman;

import java.util.ArrayList;
import java.util.List;

public class CountingConnections {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(0);
        row1.add(0);
        row1.add(1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(1);
        row2.add(1);
        row2.add(1);
        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(0);
        row3.add(0);
        row3.add(1);
        matrix.add(0, row1);
        matrix.add(1, row2);
        matrix.add(2, row3);
        System.out.println(countingConnetions(matrix));
    }

    private static int countingConnetions(List<List<Integer>> matrix) {
        int count = 0;
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> currRow = matrix.get(i);
            for (int j = 0; j < currRow.size(); j++) {
                if (currRow.get(j) == 1) {
                    //Vertical Element
                    if (j < currRow.size() - 1 && currRow.get(j + 1) == 1) {
                        count++;
                    }
                    //Horizontal Element Down
                    try {
                        if (i < matrix.size() && matrix.get(i + 1).get(j) == 1) {
                            count++;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("i" + i + "   j" + j);
                    }
                    //Diagonal Element Down
                        if ((i < matrix.size() - 1 && j < currRow.size() - 1) && matrix.get(i + 1).get(j + 1) == 1) {
                            count++;
                        }
                    //Horizontal Element Up
                    if (i > 0 && matrix.get(i - 1).get(j) == 1) {
                        count++;
                    }
                    //Diagonal Element Up
                    if ((i > 0 && j < currRow.size() - 1) && matrix.get(i - 1).get(j + 1) == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
