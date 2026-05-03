package org.bloku.task._2033;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Operations to Make a Uni-Value Grid")
@Topics({SORTING, MATH, GREEDY})
class Solution {

  public int minOperations(int[][] grid, int x) {
    int m = grid.length, n = grid[0].length;
    int[] nums = new int[m * n];
    int idx = 0;
    int rest = grid[0][0] % x;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] % x != rest) return -1;
        nums[idx++] = grid[i][j] / x;
      }
    }
    Arrays.sort(nums);
    int target = nums[nums.length / 2];
    int result = 0;
    for (int num : nums) {
      result += Math.abs(target - num);
    }
    return result;
  }
}
