package org.bloku.task._309;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Best Time to Buy and Sell Stock with Cooldown")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  public int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length + 2][2];
    for (int i = prices.length - 1; i >= 0; i--) {
      dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1] - prices[i]);
      dp[i][1] = Math.max(dp[i + 1][1], dp[i + 2][0] + prices[i]);
    }
    return dp[0][0];
  }
}
