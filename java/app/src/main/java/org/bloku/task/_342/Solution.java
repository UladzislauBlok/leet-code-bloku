package org.bloku.task._342;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Power of Four")
@Topics({MATH, BIT_MANIPULATION})
class Solution {

  // pow of 4 is x2 pow of 2
  // e.g. 4^4 = 2^8 = 256
  // we can take sqrt of n, and then check if this is pow of 2
  public boolean isPowerOfFour(int n) {
    if (n <= 0) return false;
    int n1 = (int) Math.sqrt(n);
    if (n1 != Math.sqrt(n)) return false;
    return (n1 & (n1 - 1)) == 0;
  }
}
