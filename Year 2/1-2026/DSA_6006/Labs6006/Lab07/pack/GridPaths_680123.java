package pack;

public class GridPaths_680123 {

    public int numberOfPaths(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int rows = grid.length, cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1)
            return 0;

        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for (int r = 1; r < rows; r++)
            dp[r][0] = (grid[r][0] == 1) ? 0 : dp[r - 1][0];

        for (int c = 1; c < cols; c++)
            dp[0][c] = (grid[0][c] == 1) ? 0 : dp[0][c - 1];

        for (int r = 1; r < rows; r++)
            for (int c = 1; c < cols; c++)
                dp[r][c] = (grid[r][c] == 1) ? 0 : dp[r - 1][c] + dp[r][c - 1];

        return dp[rows - 1][cols - 1];
    }
}
