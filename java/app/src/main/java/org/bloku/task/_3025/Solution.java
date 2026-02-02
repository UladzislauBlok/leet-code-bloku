package org.bloku.task._3025;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Find the Number of Ways to Place People I")
@Topics({ARRAY, MATH, SORTING, ENUMERATION})
class Solution {

  // 2 <= n <= 50
  // brute force should pass
  public int numberOfPairsOn3(int[][] points) {
    int count = 0;
    int n = points.length;
    for (int i = 0; i < n; i++) {
      int[] a = points[i];
      for (int j = 0; j < n; j++) {
        int[] b = points[j];
        if (a[0] > b[0] || a[1] < b[1] || a == b) continue;
        boolean inside = false;
        for (int k = 0; k < n; k++) {
          int[] c = points[k];
          if (a == c || b == c) // compare references
          continue;
          if (a[0] <= c[0] && b[0] >= c[0] && a[1] >= c[1] && b[1] <= c[1]) {
            inside = true;
            break;
          }
        }
        if (!inside) count++;
      }
    }
    return count;
  }

  public int numberOfPairs(int[][] points) {
    Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
    int count = 0, n = points.length;
    for (int i = 0; i < n; i++) {
      int[] a = points[i];
      int bot = -1, top = a[1];
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
