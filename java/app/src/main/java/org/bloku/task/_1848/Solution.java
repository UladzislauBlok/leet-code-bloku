package org.bloku.task._1848;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Distance to the Target Element")
@Topics({ARRAY})
class Solution {

  public int getMinDistance(int[] nums, int target, int start) {
    int left = start, right = start, n = nums.length;
    while (left >= 0 && right < n) {
      if (nums[left] == target) return start - left;
      if (nums[right] == target) return right - start;
      if (left > 0) left--;
      if (right < n - 1) right++;
    }
    return -1;
  }
}
