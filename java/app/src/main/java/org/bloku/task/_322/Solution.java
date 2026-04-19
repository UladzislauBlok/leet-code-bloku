package org.bloku.task._322;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Coin Change")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  private final int INF = (int) 1e7;
  private int[][] memo;

  public int coinChange(int[] coins, int amount) {
    this.memo = new int[coins.length][amount + 1];
    int res = dp(0, amount, coins);
    return res == INF ? -1 : res;
  }

  private int dp(int idx, int amount, int[] coins) {
    if (amount < 0 || idx == coins.length) return INF;
    if (amount == 0) return 0;
    if (memo[idx][amount] != 0) return memo[idx][amount];
    int best = dp(idx, amount - coins[idx], coins) + 1;
    best = Math.min(best, dp(idx + 1, amount, coins));
    return memo[idx][amount] = best;
  }
}
