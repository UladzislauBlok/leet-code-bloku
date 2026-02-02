package org.bloku.task._1304;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topic;
import org.bloku.util.Topics;

@LeetCodeName("Find N Unique Integers Sum up to Zero")
@Topics({Topic.ARRAY})
class Solution {

  public int[] sumZero(int n) {
    int[] res = new int[n];
    int idx = 0;
    for (int i = 1; i <= n / 2; i++) {
      res[idx++] = i;
      res[idx++] = i * -1;
    }
    if ((n & 1) == 1) res[idx] = 0;
    return res;
  }
}
