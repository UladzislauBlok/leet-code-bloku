package org.bloku.task._281;

import static org.bloku.util.Topic.*;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Zigzag Iterator")
@Topics({ARRAY, DESIGN, QUEUE})
class Solution {

  private static class ZigzagIterator {

    private final Queue<Integer> queue = new ArrayDeque<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
      int n = Math.min(v1.size(), v2.size());
      int i = 0;
      for (; i < n; i++) {
        queue.add(v1.get(i));
        queue.add(v2.get(i));
      }
      for (; i < v1.size(); i++) {
        queue.add(v1.get(i));
      }
      for (; i < v2.size(); i++) {
        queue.add(v2.get(i));
      }
    }

    public int next() {
      return queue.poll();
    }

    public boolean hasNext() {
      return !queue.isEmpty();
    }
  }
}
