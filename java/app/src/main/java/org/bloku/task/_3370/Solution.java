package org.bloku.task._3370;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Smallest Number With All Set Bits")
@Topics({BIT_MANIPULATION, MATH})
class Solution {

  public int smallestNumber(int n) {
    int res = 1;
    while (res < n) {
      res = res << 1;
      res++;
    }
    return res;
  }
}
