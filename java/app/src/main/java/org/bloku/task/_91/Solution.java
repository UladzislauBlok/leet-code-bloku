package org.bloku.task._91;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Decode Ways")
@Topics({STRING, DYNAMIC_PROGRAMMING})
class Solution {

  public int numDecodings(String s) {
    int n = s.length();
    char[] str = s.toCharArray();
    int[] dp = new int[n + 1];
    dp[n] = 1;
    for (int i = n - 1; i >= 0; i--) {
      if (str[i] == '0') continue;
      dp[i] = dp[i + 1];
      if (i == n - 1) continue;
      int num = 10 * (str[i] - '0') + str[i + 1] - '0';
      if (num <= 26) dp[i] += dp[i + 2];
    }
    return dp[0];
  }

  private char[] str;
  private int[] memo;

  public int numDecodingsTopDown(String s) {
    this.str = s.toCharArray();
    this.memo = new int[s.length()];
    Arrays.fill(memo, -1);
    return dp(0);
  }

  private int dp(int idx) {
    if (idx == str.length) return 1;
    if (memo[idx] != -1) return memo[idx];
    char curr = str[idx];
    if (curr == '0') return 0;
    int result = dp(idx + 1);
    if (idx < str.length - 1) {
      char next = str[idx + 1];
      int num = 10 * (curr - '0') + next - '0';
      if (num <= 26) {
        result += dp(idx + 2);
      }
    }
    return memo[idx] = result;
  }
}
