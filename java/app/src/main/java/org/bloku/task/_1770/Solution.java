package org.bloku.task._1770;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Score from Performing Multiplication Operations")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  public int maximumScore(int[] nums, int[] multipliers) {
    int n = nums.length, m = multipliers.length;
    int[][] dp = new int[m + 1][m + 1];

    for (int i = m - 1; i >= 0; i--) {
      for (int left = i; left >= 0; left--) {
        int mult = multipliers[i];
        int right = n - 1 - (i - left);
        int pickLeft = mult * nums[left] + dp[i + 1][left + 1];
        int pickRight = mult * nums[right] + dp[i + 1][left];
        dp[i][left] = Math.max(pickLeft, pickRight);
      }
    }

    return dp[0][0];
  }

  private int[] nums;
  private int[] multipliers;
  private int[][] memo;

  public int maximumScoreTopDown(int[] nums, int[] multipliers) {
    int n = nums.length, m = multipliers.length;
    this.nums = nums;
    this.multipliers = multipliers;
    this.memo = new int[m][m];
    return dp(0, nums.length - 1, 0);
  }

  private int dp(int left, int right, int multIdx) {
    int n = nums.length, m = multipliers.length;
    if (multIdx == m) return 0;
    if (memo[left][right - (n - m)] != 0) return memo[left][right - (n - m)];
    int best = nums[left] * multipliers[multIdx] + dp(left + 1, right, multIdx + 1);
    best = Math.max(best, nums[right] * multipliers[multIdx] + dp(left, right - 1, multIdx + 1));
    memo[left][right - (n - m)] = best;
    return best;
  }
}
