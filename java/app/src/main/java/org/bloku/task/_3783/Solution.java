package org.bloku.task._3783;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Mirror Distance of an Integer")
@Topics({MATH})
class Solution {

  public int mirrorDistance(int n) {
    int rev = 0, num = n;
    while (num > 0) {
      rev = rev * 10 + num % 10;
      num /= 10;
    }
    return Math.abs(n - rev);
  }
}
