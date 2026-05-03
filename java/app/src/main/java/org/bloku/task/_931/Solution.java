package org.bloku.task._931;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Falling Path Sum")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  public int minFallingPathSum(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];
    System.arraycopy(matrix[0], 0, dp[0], 0, n);
    for (int i = 1; i < m; i++) {
      dp[i][0] = matrix[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);
      for (int j = 1; j < n - 1; j++) {
        dp[i][j] =
            matrix[i][j] + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
      }
      dp[i][n - 1] = matrix[i][n - 1] + Math.min(dp[i - 1][n - 1], dp[i - 1][n - 2]);
    }
    int result = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) result = Math.min(result, dp[n - 1][j]);
    return result;
  }
}
