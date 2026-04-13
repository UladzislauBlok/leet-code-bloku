package org.bloku.task._973;

import static org.bloku.util.Topic.*;

import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("K Closest Points to Origin")
@Topics({HEAP_PRIORITY_QUEUE, ARRAY})
class Solution {

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq =
        new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
    for (int[] point : points) {
      pq.add(point);
      if (pq.size() > k) pq.poll();
    }
    int[][] result = new int[k][];
    for (int i = 0; i < k; i++) {
      int[] point = pq.poll();
      result[i] = point;
    }
    return result;
  }
}
