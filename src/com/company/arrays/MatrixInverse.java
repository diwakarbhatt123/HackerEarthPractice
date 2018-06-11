package com.company.arrays;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class MatrixInverse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        int testCases = Integer.parseInt(name);
        for(int i=0;i<testCases;i++){
            int N = Integer.parseInt(br.readLine());
            int matrix[][] = new int[N][N];
            for(int j=0;j<N;j++){
                String matrixRow[] = br.readLine().split(" ");
                for(int k=0;k<matrixRow.length;k++){
                    matrix[j][k] = Integer.parseInt(matrixRow[k]);
                }
                countInverse(matrix, N);
            }
        }
    }

    private static int countInverse(int[][] matrix, int n) {
        int inversions=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                if(matrix[i][j])
            }
        }
        return inversions;
    }

}
