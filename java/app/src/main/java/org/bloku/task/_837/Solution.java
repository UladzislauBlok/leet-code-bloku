package org.bloku.task._837;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Longest Harmonious Subsequence")
@Topics({MATH, DYNAMIC_PROGRAMMING, SLIDING_WINDOW, PROBABILITY})
class Solution {

  public double new21Game(int n, int k, int maxPts) {
    double[] dp = new double[k + maxPts];
    double window = 0.0;
    for (int i = k; i < k + maxPts; i++) {
      if (i <= n) dp[i] = 1.0;
      else dp[i] = 0.0;
      window += dp[i];
    }
    for (int i = k - 1; i >= 0; i--) {
      dp[i] = window / maxPts;
      window += dp[i];
      window -= dp[i + maxPts];
    }
    return dp[0];
  }
}
