package org.bloku.task._198;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("House Robber")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    int n = nums.length;
    int[] dp = new int[2];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < n; i++) {
      int max = Math.max(dp[0] + nums[i], dp[1]);
      dp[0] = dp[1];
      dp[1] = max;
    }
    return dp[1];
  }
}
