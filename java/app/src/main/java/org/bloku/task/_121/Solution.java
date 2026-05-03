package org.bloku.task._121;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Best Time to Buy and Sell Stock")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  public int maxProfit(int[] prices) {
    int max = 0;
    int buy = prices[0];
    for (int price : prices) {
      max = Math.max(max, price - buy);
      buy = Math.min(buy, price);
    }
    return max;
  }
}
