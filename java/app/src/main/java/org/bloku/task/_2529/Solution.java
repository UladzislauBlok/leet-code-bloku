package org.bloku.task._2529;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Count of Positive Integer and Negative Integer")
@Topics({ARRAY, BINARY_SEARCH, COUNTING})
class Solution {

  public int maximumCount(int[] nums) {
    int positive = 0, negative = 0;
    for (int i : nums) {
      if (i < 0) {
        negative++;
      } else if (i > 0) {
        positive++;
      }
    }
    return Math.max(positive, negative);
  }
}
