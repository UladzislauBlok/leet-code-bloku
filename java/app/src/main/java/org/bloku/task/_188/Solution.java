package org.bloku.task._188;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Best Time to Buy and Sell Stock IV")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  public int maxProfit(int k, int[] prices) {
    int n = prices.length;
    int[][][] dp = new int[n + 1][k + 1][2];
    for (int i = n - 1; i >= 0; i--) {
      dp[i][0][1] = Math.max(dp[i + 1][0][1], prices[i]);
      for (int j = k - 1; j > 0; j--) {
        dp[i][j][0] = Math.max(dp[i + 1][j][0], dp[i + 1][j - 1][1] - prices[i]);
        dp[i][j][1] = Math.max(dp[i + 1][j][1], dp[i + 1][j][0] + prices[i]);
      }
      dp[i][k][0] = Math.max(dp[i + 1][k][0], dp[i + 1][k - 1][1] - prices[i]);
    }
    return dp[0][k][0];
  }

  private int[] prices;
  private int k;
  private int[][][] memo;

  public int maxProfitTopDown(int k, int[] prices) {
    this.prices = prices;
    this.k = k;
    int n = prices.length;
    int max = 0;
    for (int price : prices) max = Math.max(max, price);
    this.memo = new int[n][k + 1][2];
    for (int[][] mat : memo) {
      for (int[] row : mat) Arrays.fill(row, -1);
    }
    return dp(0, k, false);
  }

  private int dp(int idx, int k, boolean keep) {
    if (idx == prices.length) return 0;
    if (!keep && k == 0) return 0;
    if (memo[idx][k][keep ? 1 : 0] != -1) return memo[idx][k][keep ? 1 : 0];
    int best = dp(idx + 1, k, keep);
    if (keep) {
      int sell = dp(idx + 1, k, false) + prices[idx];
      best = Math.max(best, sell);
    } else {
      int buy = dp(idx + 1, k - 1, true) - prices[idx];
      best = Math.max(best, buy);
    }
    return memo[idx][k][keep ? 1 : 0] = best;
  }
}
