package org.bloku.task._410;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Split Array Largest Sum")
@Topics({ARRAY, BINARY_SEARCH, GREEDY, PREFIX_SUM})
class Solution {

  public int splitArray(int[] nums, int k) {
    int n = nums.length;
    int low = 0, high = Integer.MAX_VALUE;
    ;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (verify(mid, k, nums)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  private boolean verify(int size, int k, int[] nums) {
    int count = 0, sum = 0;
    for (int num : nums) {
      sum += num;
      if (num > size) return false;
      if (sum > size) {
        count++;
        sum = num;
      }
    }
    return count < k;
  }

  /*
      we can dp that, but any better?
      prefix sum should help on this one
      nums.length <= 1000, so we go up to n^2
      I think key hint here is that
      if we can split nums into x chunks
      with assumption that max size is y, where x < k
      we should be gucci
  */
}
