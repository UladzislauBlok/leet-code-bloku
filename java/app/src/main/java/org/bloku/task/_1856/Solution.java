package org.bloku.task._1856;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Subarray Min-Product")
@Topics({ARRAY, STACK, MONOTONIC_STACK, PREFIX_SUM})
class Solution {

  public int maxSumMinProduct(int[] nums) {
    int n = nums.length;
    int[] stack = new int[n + 1];
    long[] prefix = new long[n];
    stack[0] = -1;
    prefix[0] = nums[0];
    int stackIdx = 1;
    long mod = (long) 1e9 + 7;
    long max = 0;
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }
    for (int i = 0; i <= n; i++) {
      while (stackIdx > 1 && nums[stack[stackIdx - 1]] > (i == n ? -1 : nums[i])) {
        int idx = stack[--stackIdx];
        int right = i - 1;
        int left = stack[stackIdx - 1];
        long currPrefix = prefix[right] - (left >= 0 ? prefix[left] : 0);
        max = Math.max(max, nums[idx] * currPrefix);
      }
      stack[stackIdx++] = i;
    }
    return (int) (max % mod);
  }
}
