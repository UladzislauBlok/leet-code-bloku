package org.bloku.task._3531;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Count Covered Buildings")
@Topics({ARRAY, HASH_TABLE})
class Solution {

  public int countCoveredBuildings2D(int n, int[][] buildings) {
    int[][] x = new int[n + 1][2];
    int[][] y = new int[n + 1][2];
    for (int[] row : x) {
      row[0] = Integer.MAX_VALUE;
      row[1] = Integer.MIN_VALUE;
    }
    for (int[] row : y) {
      row[0] = Integer.MAX_VALUE;
      row[1] = Integer.MIN_VALUE;
    }
    for (int[] building : buildings) {
      x[building[0]][0] = Math.min(x[building[0]][0], building[1]);
      x[building[0]][1] = Math.max(x[building[0]][1], building[1]);

      y[building[1]][0] = Math.min(y[building[1]][0], building[0]);
      y[building[1]][1] = Math.max(y[building[1]][1], building[0]);
    }
    int res = 0;
    for (int[] building : buildings)
      if (x[building[0]][0] < building[1]
          && x[building[0]][1] > building[1]
          && y[building[1]][0] < building[0]
          && y[building[1]][1] > building[0]) res++;
    return res;
  }

  public int countCoveredBuildings(int n, int[][] buildings) {
    int[] maxRow = new int[n + 1];
    int[] minRow = new int[n + 1];
    int[] maxCol = new int[n + 1];
    int[] minCol = new int[n + 1];
    Arrays.fill(minRow, n + 1);
    Arrays.fill(minCol, n + 1);
    for (int[] p : buildings) {
      int x = p[0];
      int y = p[1];
      maxRow[y] = Math.max(maxRow[y], x);
      minRow[y] = Math.min(minRow[y], x);
      maxCol[x] = Math.max(maxCol[x], y);
      minCol[x] = Math.min(minCol[x], y);
    }
    int res = 0;
    for (int[] p : buildings) {
      int x = p[0];
      int y = p[1];
      if (x > minRow[y] && x < maxRow[y] && y > minCol[x] && y < maxCol[x]) res++;
    }
    return res;
  }
}
