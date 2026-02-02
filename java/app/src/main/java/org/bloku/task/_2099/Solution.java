package org.bloku.task._2099;

import static org.bloku.util.Topic.*;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Subsequence of Length K With the Largest Sum")
@Topics({ARRAY, HASH_TABLE, SORTING, HEAP_PRIORITY_QUEUE})
class Solution {

  public int[] maxSubsequence(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int num : nums) {
      pq.offer(num);
    }
    for (int i = 0; i < k; i++) {
      int num = pq.poll();
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int[] res = new int[k];
    int idx = 0;
    for (int num : nums) {
      if (map.getOrDefault(num, 0) != 0) {
        res[idx++] = num;
        map.put(num, map.get(num) - 1);
      }
    }
    return res;
  }
}
