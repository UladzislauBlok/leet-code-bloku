package org.bloku.task._2221;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Triangular Sum of an Array")
@Topics({ARRAY, MATH, SIMULATION})
class Solution {

  public int triangularSum(int[] nums) {
    int n = nums.length;
    while (n > 1) {
      for (int i = 0; i < n - 1; i++) {
        nums[i] = (nums[i] + nums[i + 1]) % 10;
      }
      n--;
    }
    return nums[0];
  }
}
