package org.bloku.task._539;

import static org.bloku.util.Topic.*;

import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Time Difference")
@Topics({ARRAY, STRING, SORTING})
class Solution {

  public int findMinDifference(List<String> timePoints) {
    boolean[] times = new boolean[24 * 60];
    for (String time : timePoints) {
      int h = 10 * (time.charAt(0) - '0') + (time.charAt(1) - '0');
      int m = 10 * (time.charAt(3) - '0') + (time.charAt(4) - '0');
      if (times[h * 60 + m]) return 0;
      times[h * 60 + m] = true;
    }
    int min = Integer.MAX_VALUE;
    int prev = -1, first = -1;
    for (int i = 0; i < 24 * 60; i++) {
      if (!times[i]) continue;
      if (first == -1) first = i;
      if (prev != -1) {
        int diff = i - prev;
        min = Math.min(min, diff);
      }
      prev = i;
    }
    min = Math.min(min, 24 * 60 - prev + first);
    return min;
  }
}
