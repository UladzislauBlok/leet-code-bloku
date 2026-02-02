package org.bloku.task._1266;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Time Visiting All Points")
@Topics({MATRIX, MATH})
class Solution {

  public int minTimeToVisitAllPoints(int[][] points) {
    int res = 0;
    int n = points.length;
    for (int i = 0; i < n - 1; i++) {
      int[] point1 = points[i];
      int[] point2 = points[i + 1];
      res += Math.max(Math.abs(point1[0] - point2[0]), Math.abs(point1[1] - point2[1]));
    }
    return res;
  }
}
