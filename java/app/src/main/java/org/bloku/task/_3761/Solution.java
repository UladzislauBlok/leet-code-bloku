package org.bloku.task._3761;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Absolute Distance Between Mirror Pairs")
@Topics({ARRAY, HASH_TABLE, MATH})
class Solution {

  public int minMirrorPairDistance(int[] nums) {
    int n = nums.length;
    Map<Integer, Integer> map = new HashMap<>(n, 1.0f);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      if (map.containsKey(num)) {
        min = Math.min(min, i - map.get(num));
      }
      map.put(reverse(num), i);
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  private int reverse(int num) {
    int res = 0;
    while (num > 0) {
      res *= 10;
      res += num % 10;
      num /= 10;
    }
    return res;
  }
}
