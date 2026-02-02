package org.bloku.task._2147;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Number of Ways to Divide a Long Corridor")
@Topics({MATH, STRING, DYNAMIC_PROGRAMMING})
class Solution {

  private static final int MOD = (int) 1e9 + 7;

  public int numberOfWays_(String corridor) {
    return dp(corridor.toCharArray(), 0);
  }

  public int numberOfWays(String corridor) {
    long result = 1;
    int prevSeatIndex = 0, n = corridor.length();
    int numSeats = 0;
    char[] chars = corridor.toCharArray();

    for (int i = 0; i < n; i++) {
      char c = chars[i];
      if (c == 'S') {
        numSeats++;
        if (numSeats > 2 && numSeats % 2 == 1) {
          result = result * (i - prevSeatIndex) % MOD;
        }
        prevSeatIndex = i;
      }
    }

    return numSeats > 1 && numSeats % 2 == 0 ? (int) result : 0;
  }

  private int dp(char[] corridor, int pos) {
    int s = 0, n = corridor.length;
    while (pos < n && s < 2) {
      if (corridor[pos] == 'S') s++;
      pos++;
    }
    if (s < 2) return 0;
    int p = pos;
    while (pos < n && corridor[pos] != 'S') pos++;
    if (pos == n) return 1;
    int res = dp(corridor, pos) % MOD;
    return (int) (((pos - p + 1L) * res) % MOD);
  }
}
