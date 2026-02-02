package org.bloku.task._3354;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Make Array Elements Equal to Zero")
@Topics({ARRAY, PREFIX_SUM})
class Solution {

  // to check if we can finish process successfully
  // start point should have same amout of work
  // in left and right side
  // res++ if prefix diff(left, right) <= 1
  public int countValidSelectionsPrefix(int[] nums) {
    int n = nums.length, res = 0;
    int[] left = new int[n];
    int[] right = new int[n];
    left[0] = nums[0];
    right[n - 1] = nums[n - 1];
    for (int i = 1; i < n; i++) {
      left[i] = left[i - 1] + nums[i];
      right[n - 1 - i] = right[n - i] + nums[n - 1 - i];
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) {
        if (Math.abs(left[i] - right[i]) == 0) res += 2;
        if (Math.abs(left[i] - right[i]) == 1) res++;
      }
    }
    return res;
  }

  public int countValidSelections(int[] nums) {
    int count = 0, len = nums.length;
    int sum = 0;
    for (int num : nums) sum += num;
    int halfSum = 0;
    for (int i = 0; i < len; i++) {
      halfSum += nums[i];
      if (nums[i] == 0) {
        if (2 * halfSum == sum) {
          count += 2;
        } else if (Math.abs(sum - 2 * halfSum) == 1) {
          count++;
        }
      }
    }
    return count;
  }
}
