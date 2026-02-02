package org.bloku.task._2943;

import static org.bloku.util.Topic.*;

import java.util.Arrays;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximize Area of Square Hole in Grid")
@Topics({ARRAY, SORTING})
class Solution {

  public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
    Arrays.sort(hBars);
    Arrays.sort(vBars);
    int wh = 1, wv = 1;
    int prev = -2, w = 1;
    for (int h : hBars) {
      w = h - 1 == prev ? w + 1 : 1;
      prev = h;
      wh = Math.max(wh, w);
    }
    prev = -2;
    w = 1;
    for (int v : vBars) {
      w = v - 1 == prev ? w + 1 : 1;
      prev = v;
      wv = Math.max(wv, w);
    }
    int size = Math.min(wh, wv) + 1;
    return size * size;
  }
}
