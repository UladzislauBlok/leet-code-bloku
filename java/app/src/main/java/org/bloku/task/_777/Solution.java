package org.bloku.task._777;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Swap Adjacent in LR String")
@Topics({TWO_POINTERS, STRING})
class Solution {

  public boolean canTransform(String start, String end) {
    char[] startChars = start.toCharArray();
    char[] endChars = end.toCharArray();
    int n = start.length();
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (endChars[i] == 'L') count++;
      if (startChars[i] == 'L') count--;
      if ((startChars[i] == 'R' || endChars[i] == 'R') && count != 0) return false;
      if (count < 0) return false;
    }
    if (count != 0) return false;
    for (int i = n - 1; i >= 0; i--) {
      if (endChars[i] == 'R') count++;
      if (startChars[i] == 'R') count--;
      if ((startChars[i] == 'L' || endChars[i] == 'L') && count != 0) return false;
      if (count < 0) return false;
    }
    if (count != 0) return false;
    return true;
  }
}
