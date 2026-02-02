package org.bloku.task._3197;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the Minimum Area to Cover All Ones II")
@Topics({ARRAY, MATRIX, ENUMERATION})
class Solution {

  // 1 <= grid.length, grid[i].length <= 30
  // grid is pretty small, so can try to enumerate splitting
  // Two cases:
  // 1. 1st isn't full row, so 2nd will be remaining part + up-to end
  // 2. 1 is full row, we'll divide remaining
  // Long story short: divide grid by 2, and then remaining part one more time
  public int minimumSum(int[][] grid) {
    int m = grid.length, n = grid[0].length, sum = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int ariaA = minimumArea(grid, 0, 0, i, j);
        if (ariaA == -1) continue;

        // remaining on right and below
        if (j < n - 1 && i != m - 1) {
          // up-to i
          int ariaB = minimumArea(grid, 0, j + 1, i, n - 1);
          int ariaC = minimumArea(grid, i + 1, 0, m - 1, n - 1);
          if (ariaB != -1 && ariaC != -1) sum = Math.min(sum, ariaA + ariaB + ariaC);

          // up-to m
          ariaB = minimumArea(grid, 0, j + 1, m - 1, n - 1);
          ariaC = minimumArea(grid, i + 1, 0, m - 1, j);
          if (ariaB != -1 && ariaC != -1) sum = Math.min(sum, ariaA + ariaB + ariaC);
        }

        // remaining on right only
        if (j < n - 1 && i == m - 1) {

          // go down
          for (int k = 0; k < m - 1; k++) {
            int ariaB = minimumArea(grid, 0, j + 1, k, n - 1);
            int ariaC = minimumArea(grid, k + 1, j + 1, m - 1, n - 1);
            if (ariaB != -1 && ariaC != -1) sum = Math.min(sum, ariaA + ariaB + ariaC);
          }

          // go right
          for (int k = j + 1; k < n - 1; k++) {
            int ariaB = minimumArea(grid, 0, j + 1, m - 1, k);
            int ariaC = minimumArea(grid, 0, k + 1, m - 1, n - 1);
            if (ariaB != -1 && ariaC != -1) sum = Math.min(sum, ariaA + ariaB + ariaC);
          }
        }

        // remaining below only
        if (j == n - 1 && i < m - 1) {

          // go down
          for (int k = i + 1; k < m - 1; k++) {
            int ariaB = minimumArea(grid, i + 1, 0, k, n - 1);
            int ariaC = minimumArea(grid, k + 1, 0, m - 1, n - 1);
            if (ariaB != -1 && ariaC != -1) sum = Math.min(sum, ariaA + ariaB + ariaC);
          }

          // go right
          for (int k = 0; k < n - 1; k++) {
            int ariaB = minimumArea(grid, i + 1, 0, m - 1, k);
            int ariaC = minimumArea(grid, i + 1, k + 1, m - 1, n - 1);
            if (ariaB != -1 && ariaC != -1) sum = Math.min(sum, ariaA + ariaB + ariaC);
          }
        }
      }
    }
    return sum;
  }

  // 3195
  private int minimumArea(int[][] grid, int a, int b, int m, int n) {
    int right = Integer.MIN_VALUE, left = Integer.MAX_VALUE;
    int down = Integer.MIN_VALUE, up = Integer.MAX_VALUE;
    for (int i = a; i <= m; i++) {
      for (int j = b; j <= n; j++) {
        if (grid[i][j] == 0) continue;
        left = Math.min(left, j);
        right = Math.max(right, j);
        up = Math.min(up, i);
        down = Math.max(down, i);
      }
    }
    if (right == Integer.MIN_VALUE) return -1;
    return (down - up + 1) * (right - left + 1);
  }
}
