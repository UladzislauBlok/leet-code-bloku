package org.bloku.task._3379;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Transformed Array")
@Topics({ARRAY, SIMULATION})
class Solution {

  public int[] constructTransformedArray(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      int pos = (i + nums[i]) % n + n;
      res[i] = nums[pos % n];
    }
    return res;
  }
}
