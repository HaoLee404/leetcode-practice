package org.lee.leetcode.num41_60;

import java.util.ArrayList;
import java.util.List;

public class LC54_SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, totalNum = m * n;
        List<Integer> res = new ArrayList<>(totalNum);
        int minRow = 0, maxRow = m - 1, minCol = 0, maxCol = n - 1;
        byte direction = (byte) 0;
        for (int row = 0, col = 0; ; ) {
            res.add(matrix[row][col]);
            switch (direction) {
                case (byte) 0: // 右
                    if (++col > maxCol) {
                        --col;
                        ++minRow;
                        ++row;
                        direction = (byte) 1;
                    }
                    break;
                case (byte) 1: // 下
                    if (++row > maxRow) {
                        --row;
                        --maxCol;
                        --col;
                        direction = (byte) 2;
                    }
                    break;
                case (byte) 2: // 左
                    if (--col < minCol) {
                        ++col;
                        --maxRow;
                        --row;
                        direction = (byte) 3;
                    }
                    break;
                case (byte) 3: // 上
                    if (--row < minRow) {
                        ++row;
                        ++minCol;
                        ++col;
                        direction = (byte) 0;
                    }
                    break;
            }
            if (res.size() == totalNum)
                break;
        }
        return res;
    }
}
