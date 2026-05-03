package org.bloku.task._276;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Paint Fence")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  public int numWays(int n, int k) {
    if (n == 0) return 0;
    if (n == 1) return k;
    int minusTwo = k;
    int minusOne = k * k;
    for (int i = 3; i <= n; i++) {
      int prevDifferent = (k - 1) * minusOne;
      // if prev is same color we take all cases from (currPos - 2) * (k - 1)
      // this means all cases from currPos - 1, but decreased by one color (current one)
      int prevSame = (k - 1) * minusTwo;
      minusTwo = minusOne;
      minusOne = prevDifferent + prevSame;
    }
    return minusOne;
  }

  public int numWays2D(int n, int k) {
    if (n == 0) return 0;
    if (n == 1) return k;
    if (n == 2) return k * k;

    int[][] dp = new int[n][k];
    int[] totals = new int[n];
    for (int j = 0; j < k; j++) {
      dp[0][j] = 1;
      totals[0] += dp[0][j];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < k; j++) {
        dp[i][j] = totals[i - 1];
        if (i >= 2) {
          int invalid = (i == 2) ? 1 : (totals[i - 3] - dp[i - 3][j]);
          dp[i][j] -= invalid;
        }
        totals[i] += dp[i][j];
      }
    }

    return totals[n - 1];
  }

  /*
      4 / 2

      At point 3 I need to subtract entire line dp[i-3], without dp[i-3][j], because
      that all cases that can lead to AAA
      Why not dp[i-2]? because we will undercount (rather over subtract)
      line 1 contains AA, which at point 3 it will because AAAA - this is not possible,
      and will be already eliminated at point 2
      TL;DR we need to substact sum of line dp[i-3] + dp[i-3][j]

      0 - A               B
      1 - AA  BA          AB  BB
      2 - ABA BAA BBA     AAB ABB BAB
      3 -
  */
}
