package org.bloku.task._3000;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Area of Longest Diagonal Rectangle")
@Topics({ARRAY, MATH})
class Solution {

  public int areaOfMaxDiagonal(int[][] dimensions) {
    int maxArea = 0;
    double max = Double.MIN_VALUE;
    for (int[] row : dimensions) {
      double d = diagonal(row[0], row[1]);
      if (max < d) {
        max = d;
        maxArea = row[0] * row[1];
      } else if (max == d) {
        maxArea = Math.max(maxArea, row[0] * row[1]);
      }
    }
    return maxArea;
  }

  private double diagonal(int l, int w) {
    return Math.sqrt(l * l + w * w);
  }
}
