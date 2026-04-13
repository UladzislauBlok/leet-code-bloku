package org.bloku.task._755;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Pour Water")
@Topics({ARRAY, SIMULATION})
class Solution {

  public int[] pourWater(int[] heights, int volume, int k) {
    int n = heights.length;
    for (int i = 0; i < volume; i++) {
      int target = -1, min = heights[k];
      for (int pos = k - 1; pos >= 0; pos--) {
        if (heights[pos] < min) {
          target = pos;
          min = heights[pos];
        } else if (heights[pos] > min) {
          break;
        }
      }
      if (target != -1) {
        heights[target]++;
        continue;
      }
      for (int pos = k + 1; pos < n; pos++) {
        if (heights[pos] < min) {
          target = pos;
          min = heights[pos];
        } else if (heights[pos] > min) {
          break;
        }
      }
      if (target != -1) {
        heights[target]++;
      } else {
        heights[k]++;
      }
    }
    return heights;
  }
}
