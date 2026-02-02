package org.bloku.task._2654;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Number of Operations to Make All Array Elements Equal to 1")
@Topics({ARRAY, MATH})
class Solution {

  // proposal:
  // find pair that will give me 1 as result asap
  // propagate this 1 to entire array
  // how to achieve 1... to do so I need two prime numbers
  public int minOperations(int[] nums) {
    int ones = 0, n = nums.length;
    for (int num : nums) if (num == 1) ones++;
    if (ones != 0) return n - ones;
    int iter = 0;
    boolean changed = true;
    while (changed) {
      iter++;
      changed = false;
      for (int i = 0; i < n - 1; i++) {
        int gcd = gcd(nums[i], nums[i + 1]);
        if (gcd == 1) return n - 1 + iter;
        if (gcd != nums[i]) changed = true;
        nums[i] = gcd;
      }
    }
    return -1;
  }

  private int gcd(int a, int b) {
    if (a < b) {
      int tmp = a;
      a = b;
      b = tmp;
    }
    int rem = a % b;
    if (rem == 0) return b;
    return gcd(b, rem);
  }
}
