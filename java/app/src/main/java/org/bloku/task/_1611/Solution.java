package org.bloku.task._1611;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum One Bit Operations to Make Integers Zero")
@Topics({MATH, BIT_MANIPULATION})
class Solution {

  // proposal: dfs with memo
  // do two types of operations
  // StackOverflowError for biggest numbers
  // trying to crack it mathematically
  public int minimumOneBitOperations(int n) {
    return f(n);
  }

  int f(int n) {
    if (n == 0) return 0;
    // find leftmost bit
    int bit = 1 << 30;
    while ((n & bit) == 0) bit >>= 1;
    return ((bit << 1) - 1) - f(n - bit);
  }

  /*
  n = 8 needs 15 ops, what equals to (8<<1)-1
  1000

  1.  1001
  2.  1011
  3.  1010
  4.  1110
  5.  1111
  6.  1101
  7.  1100
  8.  0100
  9.  0101
  10. 0111
  11. 0110
  12. 0010
  13. 0011
  14. 0001
  15. 0000
  */ }
