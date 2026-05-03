package org.bloku.task._2078;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Two Furthest Houses With Different Colors")
@Topics({ARRAY, GREEDY})
class Solution {

  public int maxDistance(int[] colors) {
    int max = 0, n = colors.length;
    for (int i = n - 1; i >= 0; i--) {
      if (colors[i] != colors[0]) {
        max = i;
        break;
      }
    }
    for (int i = 0; i < n; i++) {
      if (colors[i] != colors[n - 1]) {
        max = Math.max(max, n - 1 - i);
        break;
      }
    }
    return max;
  }
}
