package org.bloku.task._1143;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Longest Common Subsequence")
@Topics({STRING, DYNAMIC_PROGRAMMING})
class Solution {

  public int longestCommonSubsequence(String text1, String text2) {
    char[] str1 = text1.toCharArray();
    char[] str2 = text2.toCharArray();
    int m = str1.length, n = str2.length;
    int[][] dp = new int[m][n];
    dp[0][0] = str1[0] == str2[0] ? 1 : 0;
    for (int j = 1; j < n; j++) {
      dp[0][j] = Math.max(dp[0][j - 1], (str1[0] == str2[j] ? 1 : 0));
    }
    for (int i = 1; i < m; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], (str1[i] == str2[0] ? 1 : 0));
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + (str1[i] == str2[j] ? 1 : 0));
      }
    }
    return dp[m - 1][n - 1];
  }
}
