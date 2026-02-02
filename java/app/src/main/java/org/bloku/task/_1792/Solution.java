package org.bloku.task._1792;

import static org.bloku.util.Topic.*;

import java.util.PriorityQueue;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Average Pass Ratio")
@Topics({GREEDY, HEAP_PRIORITY_QUEUE})
class Solution {

  public double maxAverageRatio(int[][] classes, int extraStudents) {
    PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[2], a[2]));
    for (int[] clasz : classes) {
      double[] arr = new double[3];
      arr[0] = clasz[0];
      arr[1] = clasz[1];
      arr[2] = (arr[0] + 1) / (arr[1] + 1) - arr[0] / arr[1];
      pq.offer(arr);
    }
    for (int i = 0; i < extraStudents; i++) {
      double[] arr = pq.poll();
      arr[0]++;
      arr[1]++;
      arr[2] = (arr[0] + 1) / (arr[1] + 1) - arr[0] / arr[1];
      pq.offer(arr);
    }
    double sum = 0.0;
    while (!pq.isEmpty()) {
      double[] arr = pq.poll();
      sum += arr[0] / arr[1];
    }
    return sum / classes.length;
  }
}
