package org.bloku.task._7;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Reverse Integer")
@Topics({MATH})
class Solution {

  public int reverse(int x) {
    if (x == Integer.MIN_VALUE) return 0;
    boolean negative = false;
    if (x < 0) {
      x *= -1;
      negative = true;
    }
    int res = 0;
    int max = Integer.MAX_VALUE / 10;
    while (x > 0) {
      if (res < 0 || res > max) return 0;
      res *= 10;
      res += x % 10;
      x /= 10;
    }
    return negative ? -1 * res : res;
  }
}
