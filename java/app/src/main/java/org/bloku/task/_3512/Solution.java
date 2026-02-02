package org.bloku.task._3512;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Operations to Make Array Sum Divisible by K")
@Topics({ARRAY, MATH})
class Solution {

  public int minOperations(int[] nums, int k) {
    int sum = 0;
    for (int num : nums) sum += num;
    return sum % k;
  }
}
