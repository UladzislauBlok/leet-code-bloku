package org.bloku.task._3423;

import static org.bloku.util.Topic.ARRAY;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Difference Between Adjacent Elements in a Circular Array")
@Topics({ARRAY})
class Solution {

  public int maxAdjacentDistance(int[] nums) {
    int max = Math.abs(nums[0] - nums[nums.length - 1]);
    for (int i = 1; i < nums.length; i++) {
      int diff = Math.abs(nums[i] - nums[i - 1]);
      max = Math.max(max, diff);
    }
    return max;
  }
}
