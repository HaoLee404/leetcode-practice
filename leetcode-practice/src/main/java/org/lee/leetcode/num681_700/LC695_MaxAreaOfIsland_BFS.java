package org.lee.leetcode.num681_700;

import java.util.LinkedList;
import java.util.Queue;

public class LC695_MaxAreaOfIsland_BFS {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    int count = 1;
                    queue.offer(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        int row = arr[0], col = arr[1];
                        if (isIsland(grid, row - 1, col)) {
                            count++;
                            grid[row - 1][col] = 2;
                            queue.offer(new int[] {row - 1, col});
                        }
                        if (isIsland(grid, row + 1, col)) {
                            count++;
                            grid[row + 1][col] = 2;
                            queue.offer(new int[] {row + 1, col});
                        }
                        if (isIsland(grid, row, col - 1)) {
                            count++;
                            grid[row][col - 1] = 2;
                            queue.offer(new int[] {row, col - 1});
                        }
                        if (isIsland(grid, row, col + 1)) {
                            count++;
                            grid[row][col + 1] = 2;
                            queue.offer(new int[] {row, col + 1});
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
