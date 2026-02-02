package org.bloku.task._1578;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Time to Make Rope Colorful")
@Topics({ARRAY, STRING, DYNAMIC_PROGRAMMING, GREEDY})
class Solution {

  public int minCost(String colors, int[] neededTime) {
    int n = colors.length(), res = 0;
    int right = 0, left = 0, sum = 0, max = 0;
    char[] chars = colors.toCharArray();
    while (right < n) {
      while (right < n && chars[left] == chars[right]) {
        sum += neededTime[right];
        max = Math.max(max, neededTime[right]);
        right++;
      }
      res += sum - max;
      left = right;
      max = 0;
      sum = 0;
    }
    return res;
  }

  public int minCostDp(String colors, int[] neededTime) {
    int total = 0;
    int n = neededTime.length;

    for (int i = 1; i < n; i++) {
      if (colors.charAt(i) == colors.charAt(i - 1)) {
        total += Math.min(neededTime[i], neededTime[i - 1]);
        neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
      }
    }

    return total;
  }
}
