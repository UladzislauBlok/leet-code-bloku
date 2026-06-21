package org.bloku.task._1840;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Building Height")
@Topics({ARRAY, SORTING, MATH})
class Solution {

  public int maxBuilding(int n, int[][] restrictions) {
    if (restrictions == null) {
      // or throw exception in production code
      return -1;
    }
    if (restrictions.length == 0) {
      return n - 1;
    }
    List<int[]> boundaries = new ArrayList<>();
    boundaries.add(new int[] {1, 0});
    for (int[] restriction : restrictions) {
      boundaries.add(restriction);
    }
    boundaries.sort((a, b) -> Integer.compare(a[0], b[0]));
    if (boundaries.getLast()[0] != n) {
      boundaries.add(new int[] {n, n - 1});
    }

    for (int i = 1; i < boundaries.size(); i++) {
      int distanceDiff = boundaries.get(i)[0] - boundaries.get(i - 1)[0];
      boundaries.get(i)[1] =
          Math.min(boundaries.get(i)[1], boundaries.get(i - 1)[1] + distanceDiff);
    }

    for (int i = boundaries.size() - 2; i >= 0; i--) {
      int distanceDiff = boundaries.get(i + 1)[0] - boundaries.get(i)[0];
      boundaries.get(i)[1] =
          Math.min(boundaries.get(i)[1], boundaries.get(i + 1)[1] + distanceDiff);
    }

    int maxHeight = 0;
    for (int i = 1; i < boundaries.size(); i++) {
      int distanceDiff = boundaries.get(i)[0] - boundaries.get(i - 1)[0];
      int heightDiff = Math.abs(boundaries.get(i)[1] - boundaries.get(i - 1)[1]);
      int highestBoundary = Math.max(boundaries.get(i)[1], boundaries.get(i - 1)[1]);
      maxHeight = Math.max(maxHeight, highestBoundary + (distanceDiff - heightDiff) / 2);
    }
    return maxHeight;
  }
}
