package org.bloku.task._62;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Unique Paths")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    dp[1][1] = 1;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m][n];
  }
}
