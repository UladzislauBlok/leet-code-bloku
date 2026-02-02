package org.bloku.task._2787;

import static org.bloku.util.Topic.DYNAMIC_PROGRAMMING;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Ways to Express an Integer as Sum of Powers")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  private static final int MOD = (int) 1e9 + 7;

  // It makes sense to check numbers only up to xth root of n
  // do double loop (300^2 in worst case) and check all the ways to get to curr point
  public int numberOfWays(int n, int x) {
    int[] dp = new int[n + 1];
    dp[0] = 1; // base case
    for (int i = 1; i < (int) Math.pow(n, 1.0 / x) + 2; i++) {
      int pow = (int) Math.pow(i, x);
      for (int j = n; j >= pow; j--) {
        dp[j] += dp[j - pow];
        dp[j] %= MOD;
      }
    }
    return dp[n] % MOD;
  }
}
