package org.bloku.task._3074;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Apple Redistribution into Boxes")
@Topics({ARRAY, GREEDY, SORTING, PREFIX_SUM})
class Solution {

  public int minimumBoxes(int[] apples, int[] capacity) {
    Arrays.sort(capacity);
    int sum = 0;
    for (int apple : apples) sum += apple;
    int prefix = 0, n = capacity.length;
    for (int i = n - 1; i >= 0; i--) {
      prefix += capacity[i];
      if (sum <= prefix) {
        return n - i;
      }
    }
    return -1; // never the case because of constraints
  }
}
