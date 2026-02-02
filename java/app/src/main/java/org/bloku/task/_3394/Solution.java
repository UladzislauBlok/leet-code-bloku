package org.bloku.task._3394;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Check if Grid can be Cut into Sections")
@Topics({ARRAY, SORTING})
class Solution {

  public boolean checkValidCuts(int n, int[][] rectangles) {
    List<int[]> intervals = new ArrayList<>();
    int last = -1;
    Arrays.sort(rectangles, (a, b) -> a[0] - b[0]);
    for (int i = 0; i < rectangles.length; i++) {
      if (rectangles[i][0] >= last) {
        intervals.add(new int[] {rectangles[i][0], rectangles[i][2]});
        last = rectangles[i][2];
      } else {
        last = Math.max(last, rectangles[i][2]);
        intervals.getLast()[1] = last;
      }
    }
    if (intervals.size() >= 3) return true;
    intervals.clear();
    last = -1;
    Arrays.sort(rectangles, (a, b) -> a[1] - b[1]);
    for (int i = 0; i < rectangles.length; i++) {
      if (rectangles[i][1] >= last) {
        intervals.add(new int[] {rectangles[i][1], rectangles[i][3]});
        last = rectangles[i][3];
      } else {
        last = Math.max(last, rectangles[i][3]);
        intervals.getLast()[1] = last;
      }
    }
    return intervals.size() >= 3;
  }
}
