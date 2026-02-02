package org.bloku.task._944;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Delete Columns to Make Sorted")
@Topics({ARRAY, STRING})
class Solution {

  public int minDeletionSize(String[] strs) {
    int m = strs.length, n = strs[0].length();
    int res = 0;
    for (int i = 0; i < n; i++) {
      char prev = ' ';
      for (int j = 0; j < m; j++) {
        char c = strs[j].charAt(i);
        if (prev > c) {
          res++;
          break;
        }
        prev = c;
      }
    }
    return res;
  }
}
