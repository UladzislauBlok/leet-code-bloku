package org.bloku.task._139;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Word Break")
@Topics({STRING, DYNAMIC_PROGRAMMING})
class Solution {

  public boolean wordBreak(String str, List<String> wordDict) {
    Set<String> words = new HashSet<>(wordDict);
    int n = str.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 1; i <= n; i++) {
      // 1 <= wordDict[i].length <= 20
      for (int j = i - 1; j >= Math.max(i - 21, 0); j--) {
        if (dp[j] && words.contains(str.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }

  private Set<String> words;
  private int[] memo;

  public boolean wordBreakTopDown(String str, List<String> wordDict) {
    this.words = new HashSet<>(wordDict);
    this.memo = new int[str.length()];
    Arrays.fill(memo, -1);
    return dp(0, str);
  }

  private boolean dp(int start, String str) {
    int n = str.length();
    if (start == str.length()) return true;
    if (memo[start] != -1) return memo[start] == 1;
    boolean good = false;
    for (int i = start + 1; i <= n; i++) {
      if (words.contains(str.substring(start, i))) {
        good = good || dp(i, str);
      }
    }
    memo[start] = good ? 1 : 0;
    return good;
  }
}
