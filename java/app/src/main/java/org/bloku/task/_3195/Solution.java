package org.bloku.task._3195;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the Minimum Area to Cover All Ones I")
@Topics({ARRAY, MATRIX})
class Solution {

  // Find most left, right, up, down... multiply
  public int minimumArea(int[][] grid) {
    int right = Integer.MIN_VALUE, left = Integer.MAX_VALUE;
    int down = Integer.MIN_VALUE, up = Integer.MAX_VALUE;
    int m = grid.length, n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) continue;
        left = Math.min(left, j);
        right = Math.max(right, j);
        up = Math.min(up, i);
        down = Math.max(down, i);
      }
    }
    return (down - up + 1) * (right - left + 1);
  }
}
