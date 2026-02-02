package org.bloku.task._2483;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Penalty for a Shop")
@Topics({STRING, PREFIX_SUM})
class Solution {

  public int bestClosingTime(String customers) {
    int n = customers.length();
    int res = n, penalty = 0, min = 0;
    for (int i = n - 1; i >= 0; i--) {
      penalty += customers.charAt(i) == 'Y' ? 1 : -1;
      if (penalty <= min) {
        min = penalty;
        res = i;
      }
    }
    return res;
  }

  /*
      prefix sum starting from the left
  */
}
