package org.bloku.task._762;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Prime Number of Set Bits in Binary Representation")
@Topics({MATH, BIT_MANIPULATION})
class Solution {

  private final boolean[] mask =
      new boolean[] {
        false, false, true, true, false, true, false, true, false, false, false, true, false, true,
        false, false, false, true, false, true, false
      };

  public int countPrimeSetBits(int left, int right) {
    int count = 0;
    for (int i = left; i <= right; i++) {
      int num = i;
      int bits = 0;
      while (num > 0) {
        bits += (num & 1);
        num >>= 1;
      }
      if (mask[bits]) count++;
    }
    return count;
  }
}
