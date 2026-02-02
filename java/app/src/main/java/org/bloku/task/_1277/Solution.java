package org.bloku.task._1277;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Square Submatrices with All Ones")
@Topics({ARRAY, MATRIX, DYNAMIC_PROGRAMMING})
class Solution {

  // Keys here are two other tasks: 2348 and 221
  // DP
  // Time O(M*N)
  // Space O(M*N)
  // Can be better in terms of space, if we'll use input matrix as dp matrix
  public int countSquares(int[][] matrix) {
    int res = 0, m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < n; i++) {
      if (matrix[0][i] == 1) {
        dp[0][i] = 1;
        res++;
      }
    }
    for (int i = 1; i < m; i++) { // start from 1 as 0,0 was check already
      if (matrix[i][0] == 1) {
        dp[i][0] = 1;
        res++;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 1) {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
          res += dp[i][j];
        }
      }
    }
    return res;
  }
}
