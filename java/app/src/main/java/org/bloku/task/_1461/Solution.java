package org.bloku.task._1461;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Check If a String Contains All Binary Codes of Size K")
@Topics({HASH_TABLE, STRING, BIT_MANIPULATION})
class Solution {

  public boolean hasAllCodes(String s, int k) {
    int mask = 1 << k;
    boolean[] set = new boolean[mask];
    int count = 0, curr = 0, wsize = 0, n = s.length();
    for (int i = 0; i < n; i++) {
      curr <<= 1;
      curr += s.charAt(i) - '0';
      wsize++;
      if (wsize >= k) {
        wsize--;
        if ((curr & mask) != 0) curr -= mask;
        if (!set[curr]) count++;
        set[curr] = true;
      }
    }
    return count == mask;
  }
}
