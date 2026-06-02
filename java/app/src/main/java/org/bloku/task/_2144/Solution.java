package org.bloku.task._2144;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Cost of Buying Candies With Discount")
@Topics({ARRAY, GREEDY, SORTING})
class Solution {

  public int minimumCost(int[] cost) {
    Arrays.sort(cost);
    int result = 0;

    // Iterate from the most expensive to the cheapest candy
    for (int i = cost.length - 1; i >= 0; i--) {
      // Skip every 3rd candy from the right (the free ones)
      if ((cost.length - 1 - i) % 3 == 2) {
        continue;
      }
      result += cost[i];
    }

    return result;
  }
}
