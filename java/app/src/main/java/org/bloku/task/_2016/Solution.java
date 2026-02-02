package org.bloku.task._2016;

import static org.bloku.util.Topic.ARRAY;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Difference Between Increasing Elements")
@Topics({ARRAY})
class Solution {

  public int maximumDifference(int[] nums) {
    int res = -1;
    int min = nums[0];
    int n = nums.length;
    for (int i = 1; i < n; i++) {
      if (nums[i] <= min) {
        min = nums[i];
      } else {
        res = Math.max(res, nums[i] - min);
      }
    }
    return res;
  }
}
