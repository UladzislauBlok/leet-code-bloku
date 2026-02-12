package org.bloku.task._3713;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Longest Balanced Substring I")
@Topics({HASH_TABLE, STRING, COUNTING})
class Solution {

  public int longestBalanced(String s) {
    int res = -1;
    int n = s.length();
    char[] chars = s.toCharArray();
    for (int i = 0; i < n; i++) {
      int[] f = new int[26];
      int max = -1, u = 0;
      for (int j = i; j < n; j++) {
        u += f[chars[j] - 'a'] == 0 ? 1 : 0;
        max = Math.max(max, ++f[chars[j] - 'a']);
        if (max * u == j - i + 1) res = Math.max(res, j - i + 1);
      }
    }
    return res;
  }
}
