package pack;

import java.util.Arrays;

public class MaximumSquare_680123 {
    public int maximalSquare_Recurse(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int maxSide = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                maxSide = Math.max(maxSide, maximalSquare_Recurse(grid, r, c));
            }
        }
        return maxSide * maxSide;
    }

    /* your code */
    private int maximalSquare_Recurse(int[][] grid, int r, int c) {
        // Base case: out of bounds or cell is 0 → no square ends here
        if (r < 0 || c < 0 || grid[r][c] == 0) return 0;
        // state(r,c) = 1 + min(left, up, diag)
        int left = maximalSquare_Recurse(grid, r,     c - 1);
        int up   = maximalSquare_Recurse(grid, r - 1, c);
        int diag = maximalSquare_Recurse(grid, r - 1, c - 1);
        return 1 + Math.min(left, Math.min(up, diag));
    }

    /* your code */
    public int maximalSquare_Memoiz(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        /* your code */
        int[][] memo = new int[rows][cols];
        for (int[] row : memo) Arrays.fill(row, -1); // -1 = not yet computed

        int maxSide = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxSide = Math.max(maxSide, maximalSquare_Memoiz(grid, r, c, memo));
            }
        }
        return maxSide * maxSide;
    }

    /* your code */
    private int maximalSquare_Memoiz(int[][] grid, int r, int c, int[][] memo) {
        if (r < 0 || c < 0 || grid[r][c] == 0) return 0;
        if (memo[r][c] != -1) return memo[r][c]; // already computed
        int left = maximalSquare_Memoiz(grid, r,     c - 1, memo);
        int up   = maximalSquare_Memoiz(grid, r - 1, c,     memo);
        int diag = maximalSquare_Memoiz(grid, r - 1, c - 1, memo);
        memo[r][c] = 1 + Math.min(left, Math.min(up, diag));
        return memo[r][c];
    }

    /* your code */
    public int maximalSquare_DP(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, cols = grid[0].length;
        /* your code */
        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    // Edge: first row/col can only form a 1×1 square
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = 1 + Math.min(dp[r - 1][c],
                                       Math.min(dp[r][c - 1], dp[r - 1][c - 1]));
                    }
                    maxSide = Math.max(maxSide, dp[r][c]);
                }
                // grid[r][c] == 0  →  dp[r][c] stays 0 (default)
            }
        }
        return maxSide * maxSide;
    }
}
