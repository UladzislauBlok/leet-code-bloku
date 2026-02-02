package org.bloku.task._1394;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Lucky Integer in an Array")
@Topics({ARRAY, HASH_TABLE, COUNTING})
class Solution {

  public int findLucky(int[] nums) {
    int[] map = new int[501];
    for (int num : nums) {
      map[num]++;
    }
    for (int i = 500; i >= 1; i--) {
      if (map[i] == i) return i;
    }
    return -1;
  }
}
