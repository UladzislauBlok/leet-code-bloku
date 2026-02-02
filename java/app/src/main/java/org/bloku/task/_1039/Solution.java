package org.bloku.task._1039;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Score Triangulation of Polygon")
@Topics({ARRAY, DYNAMIC_PROGRAMMING, DFS})
class Solution {

  // One line will divide polygon into two pieces
  // n is pretty small 3 <= n <= 50
  // to not recalculate things twice add memorization
  public int minScoreTriangulation(int[] values) {
    int n = values.length;
    if (n == 3) return values[0] * values[1] * values[2];
    int[][] memo = new int[n][n];
    for (int[] row : memo) {
      Arrays.fill(row, -1);
    }
    return dfs(memo, values, 0, n - 1);
  }

  private int dfs(int[][] memo, int[] v, int i, int j) {
    if (i + 1 == j) {
      return 0; // trick to stop recursion
    }
    if (memo[i][j] != -1) {
      return memo[i][j];
    }
    int min = Integer.MAX_VALUE;
    for (int k = i + 1; k < j; k++) {
      int curr = dfs(memo, v, i, k) + dfs(memo, v, k, j) + v[i] * v[j] * v[k];
      min = Math.min(min, curr);
    }
    memo[i][j] = min;
    return min;
  }
}
