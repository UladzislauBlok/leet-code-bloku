package org.bloku.task._693;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Binary Number with Alternating Bits")
@Topics({BIT_MANIPULATION})
class Solution {

  public boolean hasAlternatingBits(int n) {
    return ((n & (n >> 1)) == 0) && ((n & (n >> 2)) == (n >> 2));
  }

  public boolean hasAlternatingBits_(int n) {
    int prev = -1;
    while (n > 0) {
      if (prev == (n & 1)) return false;
      prev = n & 1;
      n >>= 1;
    }
    return true;
  }
}
