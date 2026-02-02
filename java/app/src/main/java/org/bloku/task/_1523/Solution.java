package org.bloku.task._1523;

import static org.bloku.util.Topic.MATH;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Odd Numbers in an Interval Range")
@Topics({MATH})
class Solution {

  public int countOdds(int low, int high) {
    if (low == high) return low % 2;
    low = low % 2 == 0 ? low + 1 : low;
    high = high % 2 == 0 ? high - 1 : high;
    return (high - low + 1) / 2 + 1;
  }
}
