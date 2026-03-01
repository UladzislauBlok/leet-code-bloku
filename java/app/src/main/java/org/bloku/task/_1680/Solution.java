package org.bloku.task._1680;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Concatenation of Consecutive Binary Numbers")
@Topics({MATH, BIT_MANIPULATION, SIMULATION})
class Solution {

  private final int MOD = (int) 1e9 + 7;

  public int concatenatedBinary(int n) {
    long sum = 0, offset = 1;
    for (int i = 1; i <= n; i++) {
      if ((i & (1 << offset)) != 0) offset++;
      sum <<= offset;
      sum %= MOD;
      sum += i;
    }
    return (int) sum;
  }
}
