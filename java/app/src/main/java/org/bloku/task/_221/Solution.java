package org.bloku.task._221;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximal Square")
@Topics({DYNAMIC_PROGRAMMING, MATRIX})
class Solution {

  public int maximalSquare(char[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m + 1][n + 1];
    int max = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (matrix[i - 1][j - 1] == '0') continue;
        int min = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
        dp[i][j] = min;
        max = Math.max(max, min);
      }
    }
    return max * max;
  }
}
