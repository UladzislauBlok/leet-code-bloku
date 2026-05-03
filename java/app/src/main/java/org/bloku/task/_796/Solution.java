package org.bloku.task._796;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Rotate String")
@Topics({STRING})
class Solution {

  public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) return false;
    s = s + s;
    return s.contains(goal);
  }

  public boolean rotateString_(String s, String goal) {
    int n = s.length();
    if (n != goal.length()) return false;
    char[] c1 = s.toCharArray();
    char[] c2 = goal.toCharArray();
    for (int i = 0; i < n; i++) {
      if (c1[i] != c2[0]) continue;
      boolean good = true;
      for (int j = i; j < i + n; j++) {
        if (c1[j % n] != c2[j - i]) {
          good = false;
          break;
        }
      }
      if (good) return true;
    }
    return false;
  }
}
