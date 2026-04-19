package org.bloku.task._70;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Climbing Stairs")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  public int climbStairs(int n) {
    if (n == 1) return 1;
    int[] dp = new int[] {1, 2};
    for (int i = 3; i <= n; i++) {
      int next = dp[0] + dp[1];
      dp[0] = dp[1];
      dp[1] = next;
    }
    return dp[1];
  }
}
