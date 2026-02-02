package org.bloku.task._2327;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topic;
import org.bloku.util.Topics;

@LeetCodeName("Number of People Aware of a Secret")
@Topics({Topic.DYNAMIC_PROGRAMMING})
class Solution {

  private static long MOD = (long) 1e9 + 7;

  // DP problem. we can do loopup to prev elems
  // in range [n-f+1; n-d+1)
  // calculate the sum, add it to the current one
  // at the end check the last n - f and sum
  // follow-up add memorization to not calculate it twice
  public int peopleAwareOfSecret(int n, int d, int f) {
    long[] dp = new long[n];
    dp[0] = 1;
    long memo = 0;
    for (int i = 1; i < n; i++) {
      if (i - f >= 0) memo = (memo - dp[i - f] + MOD) % MOD;
      if (i - d >= 0) memo = (memo + dp[i - d]) % MOD;
      dp[i] = memo;
    }
    long sum = 0;
    for (int i = Math.max(n - f, 0); i < n; i++) sum = (sum + dp[i]) % MOD;
    return (int) sum;
  }
}
