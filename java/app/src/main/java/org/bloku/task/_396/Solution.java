package org.bloku.task._396;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Rotate Function")
@Topics({MATH, DYNAMIC_PROGRAMMING})
class Solution {

  public int maxRotateFunction(int[] nums) {
    int sum = 0, arr = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      arr += i * nums[i];
    }
    int res = arr;
    for (int i = n - 1; i >= 0; i--) {
      arr -= (n - 1) * nums[i];
      arr += sum - nums[i];
      res = Math.max(res, arr);
    }
    return res;
  }

  /*
      we can brute force that, but it's going to be n^2, which is not good
      there is common element to calculate sum... prefix sum?

      sum == 15
      4,3,2,6 == 25

      6,4,3,2 == 16 == 25 - 18 (6*0 now) == 7 + 9 (4,3,2 once more)
  */
}
