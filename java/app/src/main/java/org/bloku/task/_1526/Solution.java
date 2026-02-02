package org.bloku.task._1526;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Number of Increments on Subarrays to Form a Target Array")
@Topics({ARRAY, DYNAMIC_PROGRAMMING, GREEDY})
class Solution {

  // kind of find rectangle
  // there are three cases: next elem > prev; next elem < prev; next elem == prev
  // only first one will affect number of required operations
  public int minNumberOperations(int[] target) {
    int res = 0, prev = 0;
    for (int num : target) {
      if (prev < num) res += num - prev;
      prev = num;
    }
    return res;
  }
}
