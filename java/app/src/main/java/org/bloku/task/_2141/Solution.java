package org.bloku.task._2141;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Running Time of N Computers")
@Topics({ARRAY, BINARY_SEARCH})
class Solution {

  public long maxRunTime(int n, int[] batteries) {
    long sum = 0;
    for (int bat : batteries) sum += bat;
    long left = 0, right = sum / n;
    while (left <= right) {
      long mid = ((right - left) / 2) + left; // mid is power per comp
      long power = 0;
      for (int battery : batteries) power += Math.min(battery, mid);
      if (power < mid * n) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left - 1;
  }
}
