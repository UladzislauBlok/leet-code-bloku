package org.bloku.task._2210;

import static org.bloku.util.Topic.ARRAY;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Hills and Valleys in an Array")
@Topics({ARRAY})
class Solution {

  public int countHillValley(int[] nums) {
    int prev = -1;
    int curr = nums[0];
    int count = 0;
    for (int num : nums) {
      if (num == curr) continue;
      if (prev != -1) {
        if ((prev < curr) == (num < curr)) count++;
      }
      prev = curr;
      curr = num;
    }
    return count;
  }
}
