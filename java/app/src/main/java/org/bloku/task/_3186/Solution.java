package org.bloku.task._3186;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Total Damage With Spell Casting")
@Topics({ARRAY, SORTING, RBT, DYNAMIC_PROGRAMMING, HASH_TABLE})
class Solution {

  // If we use some number once we'll use it everytime
  // This mean that we can reduce all occurrences into one num
  // e.g. [1,1,1,1,1,2] -> [{1-5},{2-2}]
  // And then process it in dp maner
  // For processing we need to sort, so we can combine
  // reducing and sorting -> use RBT
  // O(n log n)
  public long maximumTotalDamageRBT(int[] power) {
    TreeMap<Long, Long> map = new TreeMap<>();
    for (int p : power) {
      map.merge(1L * p, 1L * p, Long::sum);
    }
    // max num is too high to use array
    Map<Long, Long> dp = new HashMap<>();
    // three options:
    // get curr-3 (or lower) and add curr sum
    // get curr-2
    // get curr-1
    // write max to dp
    for (Map.Entry<Long, Long> e : map.sequencedEntrySet()) {
      long max = e.getValue();
      long key = e.getKey();
      Long prev = null;
      if (dp.containsKey(key - 3)) {
        prev = key - 3;
      } else {
        prev = map.lowerKey(key - 3);
      }
      if (prev != null) {
        max = Math.max(max, dp.get(prev) + e.getValue());
      }
      if (dp.containsKey(key - 2)) {
        max = Math.max(max, dp.get(key - 2));
      }
      if (dp.containsKey(key - 1)) {
        max = Math.max(max, dp.get(key - 1));
      }
      dp.put(e.getKey(), max);
    }
    return dp.get(map.lastKey());
  }

  public long maximumTotalDamage(int[] power) {
    Arrays.sort(power);
    int n = power.length;
    long[] dp = new long[n];
    long md = 0;
    dp[0] = power[0];
    for (int i = 1, j = 0; i < n; i++) {
      if (power[i] == power[i - 1]) {
        dp[i] = dp[i - 1] + power[i];
      } else {
        while (power[j] + 2 < power[i]) {
          md = Math.max(md, dp[j]);
          j++;
        }
        dp[i] = md + power[i];
      }
    }
    long max = 0;
    for (long res : dp) {
      max = Math.max(max, res);
    }
    return max;
  }
}
