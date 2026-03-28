package org.bloku.task._2573;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the String with LCP")
@Topics({ARRAY, GREEDY, DYNAMIC_PROGRAMMING, STRING})
class Solution {

  public String findTheString(int[][] lcp) {
    int n = lcp.length;
    char c = 'a';
    char[] chars = new char[n];
    for (int i = 0; i < n; i++) {
      if (chars[i] > 0) continue;
      for (int j = i; j < n; j++) if (lcp[i][j] > 0) chars[j] = c;
      if (c++ > 'z') return "";
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int v = i + 1 < n && j + 1 < n ? lcp[i + 1][j + 1] : 0;
        v = chars[i] == chars[j] ? v + 1 : 0;
        if (lcp[i][j] != v) return "";
      }
    }
    return new String(chars);
  }
}
