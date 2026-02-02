package org.bloku.task._120;

import static org.bloku.util.Topic.*;

import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Triangle")
@Topics({ARRAY, DYNAMIC_PROGRAMMING, DFS})
class Solution {

  // dp problem
  // first row is starting point
  // for first elem in row we check first in row above (0:0)
  // for lase elem in row we check last in row above (n:n-1)
  // for any other elems in row we check prev and urrent in row above (n:n-1;n)
  public int minimumTotalDp(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];
    dp[0][0] = triangle.getFirst().getFirst();
    for (int i = 1; i < n; i++) {
      List<Integer> row = triangle.get(i);
      int k = row.size();
      dp[i][0] = dp[i - 1][0] + row.getFirst();
      dp[i][k - 1] = dp[i - 1][k - 2] + row.getLast();
      for (int j = 1; j < k - 1; j++) {
        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + row.get(j);
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) min = Math.min(min, dp[n - 1][i]);
    return min;
  }

  public int minimumTotal(List<List<Integer>> tran) {
    int n = tran.size();
    Integer[][] dp = new Integer[n][n];
    return helper(dp, tran, 0, 0, n);
  }

  private int helper(Integer[][] dp, List<List<Integer>> tran, int row, int col, int end) {
    if (row == end) return 0;
    if (dp[row][col] != null) return dp[row][col];
    int left = helper(dp, tran, row + 1, col, end);
    int right = helper(dp, tran, row + 1, col + 1, end);
    return dp[row][col] = tran.get(row).get(col) + Math.min(left, right);
  }
}
