package org.bloku.task._474;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Ones and Zeroes")
@Topics({STRING, DYNAMIC_PROGRAMMING})
class Solution {

  public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (String str : strs) {
      int c0 = 0, c1 = 0;
      for (char c : str.toCharArray())
        if (c == '0') c0++;
        else c1++;
      for (int i = m; i >= c0; i--)
        for (int j = n; j >= c1; j--) dp[i][j] = Math.max(dp[i][j], dp[i - c0][j - c1] + 1);
    }
    return dp[m][n];
  }

  // can be simplified with preprocessing
  // subset ~ dp problem
  // we have two choices: include string or not
  private Map<Integer, Integer> memo = new HashMap<>();

  public int findMaxFormRecursion(String[] strs, int m, int n) {
    int k = strs.length;
    int[][] map = new int[k][2];
    for (int i = 0; i < k; i++) for (char c : strs[i].toCharArray()) map[i][c - '0']++;
    return dp(map, 0, m, n);
  }

  int dp(int[][] map, int idx, int m, int n) {
    Integer num = memo.get(idx * 1000000 + m * 1000 + n);
    if (num != null) return num;
    if (idx == map.length || m == 0 && n == 0) return 0;
    int best = -1;
    if (m >= map[idx][0] && n >= map[idx][1])
      best = dp(map, idx + 1, m - map[idx][0], n - map[idx][1]) + 1;
    best = Math.max(best, dp(map, idx + 1, m, n));
    memo.put(idx * 1000000 + m * 1000 + n, best);
    return best;
  }
}
