package org.bloku.task._1262;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Greatest Sum Divisible by Three")
@Topics({ARRAY, GREEDY, DYNAMIC_PROGRAMMING})
class Solution {

  public int maxSumDivThree(int[] nums) {
    int n = nums.length;
    int sum = 0;
    int min1a = Integer.MAX_VALUE;
    int min1b = Integer.MAX_VALUE;
    int min2a = Integer.MAX_VALUE;
    int min2b = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (nums[i] % 3 == 1) {
        if (nums[i] < min1a) {
          min1b = min1a;
          min1a = nums[i];
        } else if (nums[i] < min1b) {
          min1b = nums[i];
        }
      } else if (nums[i] % 3 == 2) {
        if (nums[i] < min2a) {
          min2b = min2a;
          min2a = nums[i];
        } else if (nums[i] < min2b) {
          min2b = nums[i];
        }
      }
    }
    if (sum % 3 == 0) return sum;
    int res = 0;
    if (sum % 3 == 1) {
      int tmp1 = min1a != Integer.MAX_VALUE ? (sum - min1a) : 0;
      int tmp2 = min2b != Integer.MAX_VALUE ? (sum - (min2a + min2b)) : 0;
      res = Math.max(tmp1, tmp2);
    }
    if (sum % 3 == 2) {
      int tmp1 = min2a != Integer.MAX_VALUE ? (sum - min2a) : 0;
      int tmp2 = min1b != Integer.MAX_VALUE ? (sum - (min1a + min1b)) : 0;
      res = Math.max(tmp1, tmp2);
    }
    return res;
  }

  public int maxSumDivThreeDp(int[] nums) {
    int[] f = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
    for (int num : nums) {
      int[] g = new int[3];
      System.arraycopy(f, 0, g, 0, 3);
      for (int i = 0; i < 3; ++i) {
        g[(i + (num % 3)) % 3] = Math.max(g[(i + (num % 3)) % 3], f[i] + num);
      }
      f = g;
    }
    return f[0];
  }

  /*
      we summarize all numbers
      there will be three cases:
      1) sum % 3 == 0 -> return res
      2) sum % 3 == 1 -> we'll need to
          subtract smallest number that num % 3 == 1
          UPD: or subtract two smallest number that num % 3 == 2
      3) sum % 3 == 2 -> we'll need to
          subtract smallest number that num % 3 == 2,
          or subtract two smallest number that num % 3 == 1
  */
}
