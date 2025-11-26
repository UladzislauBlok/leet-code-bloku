package org.bloku.task._2435;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Paths in Matrix Whose Sum Is Divisible by K")
@Topics({ARRAY, MATRIX, DYNAMIC_PROGRAMMING})
class Solution {

    private final int MOD = (int) 1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        dp[0][0][grid[0][0] % k]++;
        for (int row = 1; row < m; row++) {
            for (int i = 0; i < k; i++) {
                int prev = dp[row - 1][0][i];
                int curr = grid[row][0];
                dp[row][0][(i + curr) % k] += prev;
            }
        }
        for (int col = 1; col < n; col++) {
            for (int i = 0; i < k; i++) {
                int prev = dp[0][col - 1][i];
                int curr = grid[0][col];
                dp[0][col][(i + curr) % k] += prev;
            }
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                for (int i = 0; i < k; i++) {
                    int up = dp[row - 1][col][i];
                    int left = dp[row][col - 1][i];
                    int curr = grid[row][col];
                    dp[row][col][(i + curr) % k] += up;
                    dp[row][col][(i + curr) % k] %= MOD;
                    dp[row][col][(i + curr) % k] += left;
                    dp[row][col][(i + curr) % k] %= MOD;
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }

    /*
        high lvl idea is the as for #62
        it's dp, and for any cell number of path is sum(paths_left, paths_up)
        matrix is big 1 <= m, n <= 5 * 10^4, so if we'll check every possible result
        for final cell it will be (5 * 10^4)^2, it's not sufficient

        1 <= k <= 50, we're not interest in all value,
        we need to keep track only in interval [0;k-1]
        e.g.,
        5 -> 2
        4 -> 1
        5 -> 2
        7 -> 1
        3 -> 0

        5 -> 2
        5 -> 2
        2 -> 2
        7 -> 1
        3 -> 0
    */
}
