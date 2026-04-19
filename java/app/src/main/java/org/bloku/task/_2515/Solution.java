package org.bloku.task._2515;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Shortest Distance to Target String in a Circular Array")
@Topics({ARRAY, STRING})
class Solution {

  // not that quick at leetcode, but time complexity is better
  public int closestTarget(String[] words, String target, int startIndex) {
    Map<String, List<Integer>> map = new HashMap<>();
    int n = words.length;
    for (int i = 0; i < n; i++) {
      map.computeIfAbsent(words[i], __ -> new ArrayList<>()).add(i);
    }
    if (!map.containsKey(target)) return -1;
    int min = Integer.MAX_VALUE;
    for (int pos : map.get(target)) {
      min = Math.min(min, Math.abs(pos - startIndex));
      min = Math.min(min, Math.min(pos, startIndex) + n - Math.max(pos, startIndex));
    }
    return min;
  }
}
