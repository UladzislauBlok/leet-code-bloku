package org.bloku.task._1137;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("N-th Tribonacci Number")
@Topics({DYNAMIC_PROGRAMMING})
class Solution {

  public int tribonacci(int n) {
    if (n == 0) return 0;
    if (n < 3) return 1;
    int[] dp = new int[] {1, 1, 2};
    for (int i = 4; i <= n; i++) {
      int next = dp[0] + dp[1] + dp[2];
      dp[0] = dp[1];
      dp[1] = dp[2];
      dp[2] = next;
    }
    return dp[2];
  }
}
