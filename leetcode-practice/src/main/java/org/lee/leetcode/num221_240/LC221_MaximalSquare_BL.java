package org.lee.leetcode.num221_240;

public class LC221_MaximalSquare_BL {

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    max = Math.max(max, 1);
                    for (int i = row + 1, j = col + 1; i < matrix.length && j < matrix[0].length;) {
                        boolean flag = true;
                        for (int m = i, n = j; m >= row && n >= col;) {
                            if (matrix[m][j] != '1' || matrix[i][n] != '1') {
                                flag = false;
                                break;
                            }
                            m--;
                            n--;
                        }
                        if (flag)
                            max = Math.max(max, (i - row + 1) * (j - col + 1));
                        else
                            break;
                        i++;
                        j++;
                    }
                }
            }
        }
        return max;
    }

}
