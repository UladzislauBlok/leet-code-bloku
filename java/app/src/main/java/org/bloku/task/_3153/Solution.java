package org.bloku.task._3153;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sum of Digit Differences of All Pairs")
@Topics({ARRAY, HASH_TABLE, COUNTING})
class Solution {

  public long sumDigitDifferences(int[] nums) {
    long sum = 0;
    int n = nums.length;
    while (nums[0] > 0) {
      int[] map = new int[10];
      for (int i = 0; i < n; i++) {
        map[nums[i] % 10]++;
        nums[i] /= 10;
      }
      for (int i = 0; i <= 9; i++) {
        for (int j = i + 1; j <= 9; j++) {
          sum += 1L * map[i] * map[j];
        }
      }
    }
    return sum;
  }

  /*
      I think we can simply go over all digits in entire array
      should be O(n)
  */
}
