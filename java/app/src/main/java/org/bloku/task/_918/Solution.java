package org.bloku.task._918;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Sum Circular Subarray")
@Topics({KADANES_ALGORITHM, DIVIDE_AND_CONQUER, DYNAMIC_PROGRAMMING, ARRAY})
class Solution {

  public int maxSubarraySumCircular(int[] nums) {
    int totalSum = 0, max = Integer.MIN_VALUE / 2, min = Integer.MAX_VALUE / 2;
    int currMax = Integer.MIN_VALUE / 2, currMin = Integer.MAX_VALUE / 2;
    for (int num : nums) {
      totalSum += num;
      currMax = Math.max(currMax + num, num);
      currMin = Math.min(currMin + num, num);
      max = Math.max(max, currMax);
      min = Math.min(min, currMin);
    }
    return max > 0 ? Math.max(totalSum - min, max) : max;
  }
}
