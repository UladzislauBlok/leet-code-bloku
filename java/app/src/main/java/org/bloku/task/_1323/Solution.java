package org.bloku.task._1323;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum 69 Number")
@Topics({MATH, GREEDY})
class Solution {

  // We should change the most left 6 to 9
  public int maximum69Number(int num) {
    StringBuilder sb = new StringBuilder(String.valueOf(num));
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '6') {
        sb.setCharAt(i, '9');
        break;
      }
    }
    return Integer.parseInt(sb.toString());
  }
}
