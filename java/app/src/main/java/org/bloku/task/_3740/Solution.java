package org.bloku.task._3740;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Distance Between Three Equal Elements I")
@Topics({ARRAY, SORTING})
class Solution {

  public int minimumDistance(int[] nums) {
    int n = nums.length, max = 10000;
    int[][] numbers = new int[n][];
    for (int i = 0; i < n; i++) {
      numbers[i] = new int[] {nums[i], i};
    }
    Arrays.sort(numbers, (a, b) -> a[0] - b[0]);
    for (int i = 0; i < n - 2; i++) {
      if (numbers[i][0] == numbers[i + 1][0] && numbers[i][0] == numbers[i + 2][0]) {
        max = Math.min(max, numbers[i + 2][1] * 2 - numbers[i][1] * 2);
      }
    }
    return max == 10000 ? -1 : max;
  }
}
