package org.bloku.task._788;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Rotated Digits")
@Topics({MATH})
class Solution {

  public int rotatedDigits(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (isGood(i)) count++;
    }
    return count;
  }

  private boolean isGood(int n) {
    boolean diff = false;
    while (n > 0) {
      int digit = n % 10;
      if (digit == 3 || digit == 4 || digit == 7) return false;
      if (digit == 2 || digit == 5 || digit == 6 || digit == 9) diff = true;
      n /= 10;
    }
    return diff;
  }
}
