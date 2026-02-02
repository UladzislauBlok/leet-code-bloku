package org.bloku.task._1351;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Negative Numbers in a Sorted Matrix")
@Topics({ARRAY, MATRIX, BINARY_SEARCH})
class Solution {

  public int countNegatives(int[][] grid) {
    int res = 0, m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      int left = 0, right = n;
      while (left < right) {
        int mid = left + ((right - left) >> 1);
        if (grid[i][mid] < 0) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      res += n - left;
    }
    return res;
  }

  public int countNegatives_(int[][] grid) {
    int res = 0, m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] < 0) res++;
      }
    }
    return res;
  }
}
