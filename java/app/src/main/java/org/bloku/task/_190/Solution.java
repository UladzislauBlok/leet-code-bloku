package org.bloku.task._190;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Reverse Bits")
@Topics({MATH, BIT_MANIPULATION})
class Solution {

  public int reverseBits_(int n) {
    int res = 0, bits = 0;
    ;
    while (n > 0) {
      res <<= 1;
      res += n % 2;
      n /= 2;
      bits++;
    }
    for (int i = bits; i < 32; i++) res <<= 1;
    return res;
  }

  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res = (res << 1) | (n & 1);
      n >>>= 1;
    }
    return res;
  }
}
