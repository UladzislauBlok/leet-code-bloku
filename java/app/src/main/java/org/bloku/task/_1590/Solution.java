package org.bloku.task._1590;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Make Sum Divisible by P")
@Topics({ARRAY, PREFIX_SUM, HASH_TABLE})
class Solution {

  public int minSubarray(int[] nums, int p) {
    int sum = 0;
    for (int num : nums) sum = (sum + num) % p;
    if (sum == 0) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    int n = nums.length, min = Integer.MAX_VALUE;
    int prefix = 0;
    for (int i = 0; i < n - 1; i++) {
      prefix = (prefix + nums[i]) % p;
      if (prefix == 0) min = Math.min(min, n - i - 1);
      int diff = (prefix - sum + p) % p;
      if (map.containsKey(diff)) min = Math.min(min, i - map.get(diff));
      map.put(prefix, i);
    }
    if (map.containsKey(sum)) min = Math.min(min, map.get(sum) + 1);
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  /*
      A bit more comlicated than I expect
      There is three cases:
      1) Remove on the right
      2) Remove on the left
      3) Remove in the middle
  */
}
