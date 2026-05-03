package org.bloku.task._63;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Unique Paths II")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[][] dp = new int[m + 1][n + 1];
    dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (obstacleGrid[i - 1][j - 1] == 1) continue;
        dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m][n];
  }
}
