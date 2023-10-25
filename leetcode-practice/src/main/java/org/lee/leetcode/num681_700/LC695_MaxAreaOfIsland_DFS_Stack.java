package org.lee.leetcode.num681_700;

import java.util.LinkedList;

public class LC695_MaxAreaOfIsland_DFS_Stack {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    stack.push(new int[] {i, j});
                    grid[i][j] = 2;
                    int count = 0;
                    while (!stack.isEmpty()) {
                        int[] arr = stack.peek();
                        int row = arr[0], col = arr[1];
                        if (isIsland(grid, row - 1, col)) {
                            grid[row - 1][col] = 2;
                            stack.push(new int[] {row - 1, col});
                        } else if (isIsland(grid, row + 1, col)) {
                            grid[row + 1][col] = 2;
                            stack.push(new int[] {row + 1, col});
                        } else if (isIsland(grid, row, col - 1)) {
                            grid[row][col - 1] = 2;
                            stack.push(new int[] {row, col - 1});
                        } else if (isIsland(grid, row, col + 1)) {
                            grid[row][col + 1] = 2;
                            stack.push(new int[] {row, col + 1});
                        } else {
                            stack.pop();
                            count++;
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    private boolean isIsland(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1;
    }

}
