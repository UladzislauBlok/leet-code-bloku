package org.bloku.task._1404;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Number of Steps to Reduce a Number in Binary Representation to One")
@Topics({STRING, BIT_MANIPULATION, SIMULATION})
class Solution {

  public int numSteps(String s) {
    int zeros = 0, ones = 0, n = s.length();
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == '1') {
        ones++;
      } else if (ones > 0) {
        zeros++;
      }
    }
    if (ones == 1) {
      return n - 1;
    }
    return zeros + n + 1;
  }
}
