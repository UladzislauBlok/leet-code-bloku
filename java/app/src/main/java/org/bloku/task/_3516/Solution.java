package org.bloku.task._3516;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topic;
import org.bloku.util.Topics;

@LeetCodeName("Find Closest Person")
@Topics({Topic.MATH})
class Solution {

  public int findClosest(int x, int y, int z) {
    int a = Math.abs(z - x);
    int b = Math.abs(z - y);
    return a < b ? 1 : b == a ? 0 : 2;
  }
}
