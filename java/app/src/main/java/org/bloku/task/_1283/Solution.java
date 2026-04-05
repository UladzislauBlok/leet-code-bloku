package org.bloku.task._1283;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the Smallest Divisor Given a Threshold")
@Topics({ARRAY, BINARY_SEARCH})
class Solution {

  public int smallestDivisor(int[] nums, int threshold) {
    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    int low = 1, high = max;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (divide(mid, nums) > threshold) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private int divide(int divisor, int[] nums) {
    int count = 0;
    for (int num : nums) {
      count += (num + divisor - 1) / divisor;
    }
    return count;
  }
}
