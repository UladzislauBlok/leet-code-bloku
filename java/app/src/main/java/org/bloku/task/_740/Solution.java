package org.bloku.task._740;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Delete and Earn")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  private int[] sum;
  private int[] memo;

  public int deleteAndEarn_(int[] nums) {
    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    this.sum = new int[max + 1];
    for (int num : nums) {
      sum[num] += num;
    }
    this.memo = new int[sum.length];
    Arrays.fill(memo, -1);
    return dp(0);
  }

  private int dp(int num) {
    if (num >= sum.length) return 0;
    if (memo[num] != -1) return memo[num];
    int best = dp(num + 2) + sum[num];
    best = Math.max(best, dp(num + 1));
    memo[num] = best;
    return best;
  }

  public int deleteAndEarn(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    int[] sum = new int[max + 1];
    for (int num : nums) {
      sum[num] += num;
    }
    int[] dp = new int[max + 1];
    dp[0] = sum[0];
    dp[1] = Math.max(sum[0], sum[1]);
    for (int i = 2; i <= max; i++) {
      dp[i] = Math.max(dp[i - 1], sum[i] + dp[i - 2]);
    }
    return dp[max];
  }
}
