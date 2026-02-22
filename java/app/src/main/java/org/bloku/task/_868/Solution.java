package org.bloku.task._868;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Binary Gap")
@Topics({BIT_MANIPULATION})
class Solution {

  public int binaryGap(int n) {
    int prev = -1;
    int max = 0;
    for (int i = 0; i <= 31; i++) {
      int mask = 1 << i;
      if ((n & mask) == mask) {
        if (prev != -1) max = Math.max(max, i - prev);
        prev = i;
      }
    }
    return max;
  }
}
