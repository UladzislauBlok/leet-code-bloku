package org.bloku.task._2125;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Number of Laser Beams in a Bank")
@Topics({STRING, MATRIX})
class Solution {

  public int numberOfBeams(String[] bank) {
    int n = bank.length, m = bank[0].length();
    int count = 0;
    int prev = 0;
    for (int i = 0; i < n; i++) {
      int curr = 0;
      for (int j = 0; j < m; j++) curr += (bank[i].charAt(j) - '0');
      count += prev * curr;
      if (curr != 0) prev = curr;
    }
    return count;
  }
}
