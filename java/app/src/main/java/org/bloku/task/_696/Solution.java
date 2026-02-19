package org.bloku.task._696;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Binary Substrings")
@Topics({STRING, TWO_POINTERS})
class Solution {

  public int countBinarySubstrings(String s) {
    char[] chars = s.toCharArray();
    int prev = 0, curr = 1, res = 0, n = s.length();
    for (int i = 0; i < n - 1; i++) {
      if (chars[i] == chars[i + 1]) {
        curr++;
      } else {
        res += Math.min(prev, curr);
        prev = curr;
        curr = 1;
      }
    }
    return res + Math.min(prev, curr);
  }
}
