package org.bloku.task._3013;

import static org.bloku.util.Topic.*;

import java.util.PriorityQueue;
import java.util.TreeSet;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Divide an Array Into Subarrays With Minimum Cost II")
@Topics({ARRAY, HASH_TABLE, SLIDING_WINDOW, HEAP_PRIORITY_QUEUE, RBT})
class Solution {

  public long minimumCost_(int[] nums, int k, int dist) {
    long min = Long.MAX_VALUE;
    int n = nums.length;
    TreeSet<int[]> rbtL = new TreeSet<>((a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
    TreeSet<int[]> rbtH = new TreeSet<>((a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
    long sum = 0;
    for (int i = 2; i < n; i++) {
      rbtH.add(new int[] {nums[i - 1], i - 1});
      if (i - dist - 1 > 0) {
        int[] r = new int[] {nums[i - dist - 1], i - dist - 1};
        rbtH.remove(r);
        if (rbtL.remove(r)) {
          sum -= r[0];
        }
      }
      while (rbtL.size() < k - 2 && !rbtH.isEmpty()) {
        int[] h = rbtH.pollFirst();
        rbtL.add(h);
        sum += h[0];
      }
      while (!rbtH.isEmpty() && rbtL.last()[0] > rbtH.first()[0]) {
        int[] l = rbtL.pollLast();
        int[] h = rbtH.pollFirst();
        sum -= l[0];
        sum += h[0];
        rbtL.add(h);
        rbtH.add(l);
      }
      if (rbtL.size() < k - 2) continue;
      min = Math.min(min, sum + nums[0] + nums[i]);
    }
    return min;
  }

  public long minimumCost(int[] nums, int k, int dist) {
    PriorityQueue<int[]> rest = new PriorityQueue<>((a, b) -> a[0] - b[0]); // num - idx
    PriorityQueue<int[]> kMin =
        new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    int n = nums.length;
    long sum = 0;
    for (int i = 1; i < k; i++) {
      kMin.add(new int[] {nums[i], i});
      sum += nums[i];
    }
    long min = sum;
    for (int i = k; i < n; i++) {
      int lowIdx = i - dist;
      pop(rest, lowIdx);
      rest.add(new int[] {nums[i], i});
      if (lowIdx > 1) {
        if (nums[lowIdx - 1] < kMin.peek()[0]
            || lowIdx - 1 == kMin.peek()[1]) { // protected by kMin a[1] - b[1]
          int[] moved = rest.poll();
          kMin.add(moved);
          sum += moved[0] - nums[lowIdx - 1];
        }
      }
      pop(rest, lowIdx);
      pop(kMin, lowIdx);
      if (!rest.isEmpty() && rest.peek()[0] < kMin.peek()[0]) {
        int[] rem = kMin.poll();
        int[] add = rest.poll();
        rest.add(rem);
        kMin.add(add);
        sum += add[0] - rem[0];
      }
      min = Math.min(min, sum);
    }
    return min + nums[0];
  }

  private void pop(PriorityQueue<int[]> pq, int start) {
    while (!pq.isEmpty() && pq.peek()[1] < start) pq.poll();
  }

  /*
      the dist is max size of window from first and second elements
      so what we need to do is check every index
      with backward window of size dist
      and chose k - 2 min elems (+ 0 and current)
      did it with two RBT
      Can be rebuid with two PQ:
      for k: compare with b[1] - a[1]
      for rest: a[1] - b[1]
  */
}
