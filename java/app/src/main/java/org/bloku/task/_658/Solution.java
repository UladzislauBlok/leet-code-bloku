package org.bloku.task._658;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find K Closest Elements")
@Topics({ARRAY, TWO_POINTERS, HEAP_PRIORITY_QUEUE, BINARY_SEARCH})
class Solution {

  public List<Integer> findClosestElements(int[] nums, int k, int x) {
    List<Integer> result = new ArrayList<>();
    int low = 0;
    int high = nums.length - 1;
    while (high - low + 1 > k) {
      int start = x - nums[low];
      int end = nums[high] - x;
      if (start > end) {
        low++;
      } else {
        high--;
      }
    }
    for (int i = low; i < low + k; i++) result.add(nums[i]);
    return result;
  }

  public List<Integer> findClosestElements_(int[] nums, int k, int x) {
    PriorityQueue<Integer> pq =
        new PriorityQueue<>(
            (a, b) -> {
              int diff = Math.abs(x - b) - Math.abs(x - a);
              if (diff == 0) {
                return b - a;
              }
              return diff;
            });
    for (int num : nums) {
      pq.add(num);
      if (pq.size() > k) pq.poll();
    }
    List<Integer> result = new ArrayList<>(pq);
    result.sort((a, b) -> a - b);
    return result;
  }
}
