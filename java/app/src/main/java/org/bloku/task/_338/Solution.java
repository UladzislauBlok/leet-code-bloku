package org.bloku.task._338;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Counting Bits")
@Topics({DYNAMIC_PROGRAMMING, MATH, BIT_MANIPULATION})
class Solution {

  public int[] countBits_(int n) {
    int[] result = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      result[i] = result[i & (i - 1)] + 1;
    }
    return result;
  }

  public int[] countBits(int n) {
    int[] ans = new int[n + 1];
    for (int x = 1; x <= n; ++x) {
      ans[x] = ans[x >> 1] + (x & 1);
    }
    return ans;
  }
}
