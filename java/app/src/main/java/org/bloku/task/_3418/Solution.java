package org.bloku.task._3418;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Amount of Money Robot Can Earn")
@Topics({DYNAMIC_PROGRAMMING, MATRIX})
class Solution {

  public int maximumAmount(int[][] coins) {
    int m = coins.length, n = coins[0].length;
    int[][][] dp = new int[m][n][3];
    dp[0][0][2] = coins[0][0];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 & j == 0) continue;
        int coin = coins[i][j];
        for (int k = 0; k < 3; k++) {
          int top = i > 0 ? dp[i - 1][j][k] : Integer.MIN_VALUE / 2;
          int left = j > 0 ? dp[i][j - 1][k] : Integer.MIN_VALUE / 2;
          dp[i][j][k] = Math.max(top, left) + coin;
          if (coin < 0 && k < 2) {
            top = i > 0 ? dp[i - 1][j][k + 1] : Integer.MIN_VALUE / 2;
            left = j > 0 ? dp[i][j - 1][k + 1] : Integer.MIN_VALUE / 2;
            dp[i][j][k] = Math.max(dp[i][j][k], Math.max(top, left));
          }
        }
      }
    }
    int[] end = dp[m - 1][n - 1];
    return Math.max(end[0], Math.max(end[1], end[2]));
  }

  /*
      it's dp, but robbers make problems,
      for every robber point we have two chooses: give money or fight (auf)
      sometimes it will make sense to give money away,
      'cause later we can encounter robber with higher (lower) number
      top-down or bottom-up?? let's try with 3d bottom-up

  */
}
