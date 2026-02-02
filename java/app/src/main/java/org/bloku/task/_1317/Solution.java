package org.bloku.task._1317;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topic;
import org.bloku.util.Topics;

@LeetCodeName("Convert Integer to the Sum of Two No-Zero Integers")
@Topics({Topic.MATH})
class Solution {

  public int[] getNoZeroIntegers(int n) {
    int a = 1;
    while (true) {
      int b = n - a;
      if (!hasZero(a) && !hasZero(b)) break;
      a++;
    }
    return new int[] {a, n - a};
  }

  private boolean hasZero(int num) {
    while (num > 0) {
      if (num % 10 == 0) return true;
      num /= 10;
    }
    return false;
  }
}
