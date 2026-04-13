package org.bloku.task._1937;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Number of Points with Cost")
@Topics({ARRAY, DYNAMIC_PROGRAMMING, MATRIX})
class Solution {

  public long maxPoints(int[][] points) {
    int m = points.length, n = points[0].length;
    long[] dp = new long[n];
    for (int j = 0; j < n; j++) dp[j] = points[0][j];
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) dp[j] = Math.max(dp[j], dp[j - 1] - 1);
      for (int j = n - 2; j >= 0; j--) dp[j] = Math.max(dp[j], dp[j + 1] - 1);
      for (int j = 0; j < n; j++) dp[j] += points[i][j];
    }
    long max = -1;
    for (int j = 0; j < n; j++) max = Math.max(max, dp[j]);
    return max;
  }
}
