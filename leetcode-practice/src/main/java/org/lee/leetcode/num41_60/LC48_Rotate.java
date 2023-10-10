package org.lee.leetcode.num41_60;

public class LC48_Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n >>> 1; row++) {
            for (int col = 0; col < n + 1 >>> 1; col++) {
                int d = matrix[row][col];
                matrix[row][col] = matrix[n - col - 1][row];
                matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
                matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];
                matrix[col][n - row - 1] = d;
            }
        }
    }

}
