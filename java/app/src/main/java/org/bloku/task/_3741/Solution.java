package org.bloku.task._3741;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Distance Between Three Equal Elements II")
@Topics({ARRAY, HASH_TABLE})
class Solution {

  public int minimumDistance_(int[] nums) {
    int n = nums.length, max = Integer.MAX_VALUE;
    List<Integer>[] numbers = new List[n + 1];
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      if (numbers[num] == null) numbers[num] = new ArrayList<>();
      numbers[num].add(i);
    }
    for (List list : numbers) {
      if (list == null) continue;
      int k = list.size();
      if (k < 3) continue;
      for (int i = 0; i < k - 2; i++) {
        Integer a = (Integer) list.get(i);
        Integer b = (Integer) list.get(i + 2);
        max = Math.min(max, b * 2 - a * 2);
      }
    }
    return max == Integer.MAX_VALUE ? -1 : max;
  }

  public int minimumDistanceMap(int[] nums) {
    int n = nums.length, max = Integer.MAX_VALUE;
    Map<Integer, List<Integer>> numbers = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      numbers.computeIfAbsent(num, __ -> new ArrayList<>()).add(i);
    }
    for (List<Integer> list : numbers.values()) {
      int k = list.size();
      if (k < 3) continue;
      for (int i = 0; i < k - 2; i++) {
        Integer a = list.get(i);
        Integer b = list.get(i + 2);
        max = Math.min(max, b * 2 - a * 2);
      }
    }
    return max == Integer.MAX_VALUE ? -1 : max;
  }

  public int minimumDistance(int[] nums) {
    int n = nums.length;
    int max = Integer.MAX_VALUE;
    int[] prev1 = new int[n + 1];
    int[] prev2 = new int[n + 1];
    for (int i = 0; i < n + 1; i++) {
      prev1[i] = prev2[i] = -1;
    }
    for (int i = 0; i < n; i++) {
      int value = nums[i];
      if (prev2[value] != -1) {
        max = Math.min(max, (i * 2 - prev2[value] * 2));
      }
      prev2[value] = prev1[value];
      prev1[value] = i;
    }
    return max == Integer.MAX_VALUE ? -1 : max;
  }
}
