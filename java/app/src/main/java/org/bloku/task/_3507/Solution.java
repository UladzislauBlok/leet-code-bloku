package org.bloku.task._3507;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Pair Removal to Sort Array I")
@Topics({ARRAY, SIMULATION})
class Solution {

  private static final int PREV = -1000000;

  public int minimumPairRemoval(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      int prev = PREV, prevPos = -1, minSum = 100000;
      int[] minPos = new int[2];
      boolean good = true;
      for (int j = 0; j < n; j++) {
        int num = nums[j];
        if (num == Integer.MIN_VALUE) continue;
        if (prev != PREV) {
          int sum = prev + num;
          if (sum < minSum) {
            minPos[0] = prevPos;
            minPos[1] = j;
            minSum = sum;
          }
          if (num < nums[prevPos]) good = false;
        }
        prevPos = j;
        prev = num;
      }
      if (good) return i;
      nums[minPos[0]] = Integer.MIN_VALUE;
      nums[minPos[1]] = minSum;
    }
    return -1;
  }
}
