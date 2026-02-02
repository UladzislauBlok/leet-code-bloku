package org.bloku.task._1493;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Longest Subarray of 1's After Deleting One Element")
@Topics({ARRAY, SLIDING_WINDOW, DYNAMIC_PROGRAMMING})
class Solution {

  // Sliding window for max subarray with only one 0
  public int longestSubarray(int[] nums) {
    int left = 0, right = 0, max = Integer.MIN_VALUE, zeros = 0, n = nums.length;
    while (right < n) {
      if (nums[right++] == 0) zeros++;
      while (zeros > 1) if (nums[left++] == 0) zeros--;
      max = Math.max(max, right - left);
    }
    return max - 1; // window size minus one deleted element (even 1)
  }

  // dp going left -> right and left <- right
  public int longestSubarrayDP(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = 0;
    for (int i = 1; i < n; i++) {
      if (nums[i - 1] == 0) dp[i] = 0;
      else dp[i] = dp[i - 1] + 1;
    }
    int max = dp[n - 1], right = 0;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i + 1] == 0) right = 0;
      else right++;
      max = Math.max(max, dp[i] + right);
    }
    return max;
  }
}
