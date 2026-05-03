package org.bloku.task._3742;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Path Score in a Grid")
@Topics({DYNAMIC_PROGRAMMING, ARRAY})
class Solution {

  public int maxPathScore(int[][] grid, int K) {
    int m = grid.length, n = grid[0].length;
    int[][][] dp = new int[m][n][K + 1];
    for (int[][] mat : dp) {
      for (int[] row : mat) Arrays.fill(row, -1);
    }
    dp[0][0][0] = 0;
    for (int i = 1; i < m; i++) {
      int cost = grid[i][0] > 0 ? 1 : 0;
      for (int k = 0; k <= K - cost; k++) {
        if (dp[i - 1][0][k] == -1) continue;
        dp[i][0][k + cost] = dp[i - 1][0][k] + grid[i][0];
      }
    }
    for (int j = 1; j < n; j++) {
      int cost = grid[0][j] > 0 ? 1 : 0;
      for (int k = 0; k <= K - cost; k++) {
        if (dp[0][j - 1][k] == -1) continue;
        dp[0][j][k + cost] = dp[0][j - 1][k] + grid[0][j];
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        int cost = grid[i][j] > 0 ? 1 : 0;
        for (int k = 0; k <= K - cost; k++) {
          if (dp[i - 1][j][k] == -1 && dp[i][j - 1][k] == -1) continue;
          dp[i][j][k + cost] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]) + grid[i][j];
        }
      }
    }
    int best = -1;
    for (int res : dp[m - 1][n - 1]) best = Math.max(best, res);
    return best;
  }
}
