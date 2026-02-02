package org.bloku.task._122;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Best Time to Buy and Sell Stock II")
@Topics({ARRAY, DYNAMIC_PROGRAMMING, GREEDY})
class Solution {

  public int maxProfit(int[] prices) {
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }

    return profit;
  }
}
