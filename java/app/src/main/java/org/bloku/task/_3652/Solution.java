package org.bloku.task._3652;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Best Time to Buy and Sell Stock using Strategy")
@Topics({ARRAY, SLIDING_WINDOW, PREFIX_SUM})
class Solution {

  public long maxProfit(int[] prices, int[] strategy, int k) {
    int n = prices.length;
    long[] sum = new long[n + 1];
    long[] prefix = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + prices[i];
      prefix[i + 1] = prefix[i] + prices[i] * strategy[i];
    }
    long best = 0;
    for (int i = 0; i <= n - k; i++) {
      long modif = sum[i + k] - sum[i + k / 2];
      long curr = prefix[i + k] - prefix[i];
      best = Math.max(best, modif - curr);
    }
    return prefix[n] + best;
  }

  /*
      sliding window and prefix
      we need to find how to maximize positive effect
      We take window of size k:
      * original sum is no modification
      * modified sum is original before window + skip first half + sum of second
      final result is original sum + max(best after modification, 0)
  */
}
