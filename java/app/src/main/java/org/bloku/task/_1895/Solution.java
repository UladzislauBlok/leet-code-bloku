package org.bloku.task._1895;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Largest Magic Square")
@Topics({ARRAY, MATRIX, PREFIX_SUM})
class Solution {

  public int largestMagicSquare(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][][] prefix = new int[m + 1][n + 1][2];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int num = grid[i][j];
        prefix[i][j + 1][0] = prefix[i][j][0] + num;
        prefix[i + 1][j][1] = prefix[i][j][1] + num;
      }
    }
    for (int k = Math.min(m, n); k >= 1; k--) {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (m - i >= k && n - j >= k && verify(grid, prefix, i, j, k)) return k;
        }
      }
    }
    return 1;
  }

  private boolean verify(int[][] grid, int[][][] prefix, int row, int col, int k) {
    int expected = prefix[row][col + k][0] - prefix[row][col][0];
    for (int i = row; i < row + k; i++) {
      int num = prefix[i][col + k][0] - prefix[i][col][0];
      if (expected != num) return false;
    }
    for (int j = col; j < col + k; j++) {
      int num = prefix[row + k][j][1] - prefix[row][j][1];
      if (expected != num) return false;
    }
    int sum1 = 0;
    int sum2 = 0;
    for (int i = 0; i < k; i++) {
      sum1 += grid[row + i][col + i];
      sum2 += grid[row + i][col + k - 1 - i];
    }
    return expected == sum1 && expected == sum2;
  }
}
