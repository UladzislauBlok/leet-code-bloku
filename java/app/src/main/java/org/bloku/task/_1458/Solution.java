package org.bloku.task._1458;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Max Dot Product of Two Subsequences")
@Topics({ARRAY, DYNAMIC_PROGRAMMING})
class Solution {

  public int maxDotProduct(int[] nums1, int[] nums2) {
    int n1 = nums1.length, n2 = nums2.length;
    int[] dp = new int[n1];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n1; i++) {
      max = Math.max(max, nums1[i] * nums2[0]);
      dp[i] = max;
    }
    for (int i = 1; i < n2; i++) {
      int[] n_dp = Arrays.copyOf(dp, n1);
      max = nums1[0] * nums2[i];
      n_dp[0] = Math.max(dp[0], max);
      for (int j = 1; j < n1; j++) {
        max = Math.max(max, dp[j - 1] + nums1[j] * nums2[i]);
        max = Math.max(max, nums1[j] * nums2[i]);
        n_dp[j] = Math.max(dp[j], max);
      }
      dp = n_dp;
    }
    max = Integer.MIN_VALUE;
    for (int num : dp) max = Math.max(max, num);
    return max;
  }
}
