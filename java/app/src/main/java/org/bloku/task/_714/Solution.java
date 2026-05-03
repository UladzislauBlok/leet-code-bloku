package org.bloku.task._714;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Best Time to Buy and Sell Stock with Transaction Fee")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  public int maxProfit_(int[] prices, int fee) {
    int hold = -prices[0];
    int cash = 0;
    for (int i = 1; i < prices.length; i++) {
      int prevHold = hold;
      int prevCash = cash;
      hold = Math.max(prevHold, prevCash - prices[i]);
      cash = Math.max(prevCash, prevHold + prices[i] - fee);
    }
    return cash;
  }

  public int maxProfit(int[] prices, int fee) {
    int n = prices.length;
    int[][] dp = new int[n + 1][2];
    for (int i = n - 1; i >= 0; i--) {
      dp[i][0] = Math.max(dp[i + 1][0], dp[i + 1][1] - prices[i]);
      dp[i][1] = Math.max(dp[i + 1][1], dp[i + 1][0] + prices[i] - fee);
    }
    return dp[0][0];
  }

  private int fee;
  private int[] prices;
  private int[][] memo;

  public int maxProfitTowDown(int[] prices, int fee) {
    this.fee = fee;
    this.prices = prices;
    this.memo = new int[prices.length][2];
    for (int[] row : memo) Arrays.fill(row, -1);
    return dp(0, 0);
  }

  private int dp(int idx, int keep) {
    if (idx == prices.length) return 0;
    if (memo[idx][keep] != -1) return memo[idx][keep];
    int best = dp(idx + 1, keep);
    if (keep == 1) {
      best = Math.max(best, dp(idx + 1, 0) + prices[idx] - fee);
    } else {
      best = Math.max(best, dp(idx + 1, 1) - prices[idx]);
    }
    return memo[idx][keep] = best;
  }
}
