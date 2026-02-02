package org.bloku.task._2169;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Operations to Obtain Zero")
@Topics({MATH, SIMULATION})
class Solution {

  public int countOperations1(int num1, int num2) {
    int count = 0;
    while (num1 != 0 && num2 != 0) {
      int diff = Math.abs(num1 - num2);
      if (num1 > num2) {
        num1 = diff;
      } else {
        num2 = diff;
      }
      count++;
    }
    return count;
  }

  public int countOperations(int num1, int num2) {
    int count = 0;
    while (num1 != 0 && num2 != 0) {
      count += num1 / num2;
      num1 %= num2;
      int tmp = num1;
      num1 = num2;
      num2 = tmp;
    }
    return count;
  }
}
