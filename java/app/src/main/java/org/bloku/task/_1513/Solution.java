package org.bloku.task._1513;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Number of Substrings With Only 1s")
@Topics({MATH, STRING})
class Solution {

  private final int MOD = (int) 1e9 + 7;

  public int numSub(String s) {
    int res = 0;
    long count = 0;
    for (char c : s.toCharArray()) {
      if (c == '0') {
        res += (int) ((count * (count + 1) / 2) % MOD);
        count = 0;
      } else {
        count++;
      }
    }
    res += (int) ((count * (count + 1) / 2) % MOD);
    return res;
  }

  /*
  Num of substrings can be calucated with N*(N+1)/2
  e.g., 111111 -> 21 = 6 * 7 / 2
  */
}
