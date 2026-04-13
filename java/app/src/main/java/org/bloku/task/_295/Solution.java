package org.bloku.task._295;

import static org.bloku.util.Topic.*;

import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find Median from Data Stream")
@Topics({DESIGN, HEAP_PRIORITY_QUEUE})
class Solution {

  class MedianFinder {

    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    public MedianFinder() {}

    public void addNum(int num) {
      minHeap.add(num);
      if (minHeap.size() - maxHeap.size() > 1) {
        maxHeap.add(minHeap.poll());
      }
      while (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
        int tmp = minHeap.poll();
        minHeap.add(maxHeap.poll());
        maxHeap.add(tmp);
      }
    }

    public double findMedian() {
      if (minHeap.size() == maxHeap.size()) {
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
      }
      return minHeap.peek();
    }
  }
}
