package org.bloku.task._2110;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Number of Smooth Descent Periods of a Stock")
@Topics({ARRAY, MATH, DYNAMIC_PROGRAMMING})
class Solution {

  public long getDescentPeriods(int[] prices) {
    long res = 0;
    int prev = -1, window = 0;
    for (int price : prices) {
      if (prev - 1 == price) {
        window++;
      } else {
        window = 1;
      }
      res += window;
      prev = price;
    }
    return res;
  }
}
