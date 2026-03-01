package org.bloku.task._1689;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Partitioning Into Minimum Number Of Deci-Binary Numbers")
@Topics({STRING, GREEDY})
class Solution {

  public int minPartitions(String n) {
    int max = 0;
    for (char c : n.toCharArray()) max = Math.max(max, c - '0');
    return max;
  }
}
