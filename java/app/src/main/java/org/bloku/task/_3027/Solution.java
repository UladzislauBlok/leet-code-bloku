package org.bloku.task._3027;

import static org.bloku.util.Topic.ARRAY;
import static org.bloku.util.Topic.ENUMERATION;
import static org.bloku.util.Topic.MATH;
import static org.bloku.util.Topic.SORTING;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the Number of Ways to Place People II")
@Topics({ARRAY, MATH, SORTING, ENUMERATION})
class Solution {

  // Just solution from yesterday :)
  // O(n^2)
  // Find the Number of Ways to Place People I
  public int numberOfPairs(int[][] points) {
    Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    int count = 0, n = points.length;
    for (int i = 0; i < n; i++) {
      int[] a = points[i];
      int bot = Integer.MIN_VALUE, top = a[1];
      for (int j = i + 1; j < n; j++) {
        int[] b = points[j];
        if (b[1] <= top && b[1] > bot) { // find the smallest one == min top and max bot
          count++;
          bot = b[1];
          if (b[1] == top) // for case when there is horizontal line
          top--;
        }
      }
    }
    return count;
  }
}
