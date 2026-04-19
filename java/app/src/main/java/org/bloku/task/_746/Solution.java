package org.bloku.task._746;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Min Cost Climbing Stairs")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[] {cost[0], cost[1]};
    int n = cost.length;
    for (int i = 2; i < n; i++) {
      int curr = cost[i] + Math.min(dp[0], dp[1]);
      dp[0] = dp[1];
      dp[1] = curr;
    }
    return Math.min(dp[0], dp[1]);
  }
}
