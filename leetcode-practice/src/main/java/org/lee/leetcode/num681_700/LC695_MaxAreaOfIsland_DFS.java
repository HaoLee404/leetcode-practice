package org.lee.leetcode.num681_700;

public class LC695_MaxAreaOfIsland_DFS {

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                max = Math.max(max, dfs(grid, i, j));
        }
        return max;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return 0;
        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            return dfs(grid, row - 1, col) + dfs(grid, row + 1, col)
                    + dfs(grid, row, col -1) + dfs(grid, row, col + 1)
                    + 1;
        }
        return 0;
    }

}
