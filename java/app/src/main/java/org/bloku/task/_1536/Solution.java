package org.bloku.task._1536;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Minimum Swaps to Arrange a Binary Grid")
@Topics({ARRAY, GREEDY, MATRIX})
class Solution {

  public int minSwaps(int[][] grid) {
    int n = grid.length, count = 0;
    int[] zeros = new int[n];
    fillZeros(grid, zeros);
    for (int i = 0; i < n; i++) {
      int target = n - 1 - i;
      int pos = find(zeros, i, target);
      if (pos == -1) return -1;
      for (; pos > i; pos--) {
        int tmp = zeros[pos - 1];
        zeros[pos - 1] = zeros[pos];
        zeros[pos] = tmp;
        count++;
      }
    }
    return count;
  }

  private void fillZeros(int[][] grid, int[] zeros) {
    int n = grid.length;
    for (int i = 0; i < n; i++) {
      int count = n;
      for (int j = n - 1; j >= 0; j--) {
        int num = grid[i][j];
        if (num == 1) {
          count = n - j - 1;
          break;
        }
      }
      zeros[i] = count;
    }
  }

  private int find(int[] zeros, int start, int target) {
    int n = zeros.length;
    for (int i = start; i < n; i++) if (zeros[i] >= target) return i;
    return -1;
  }
}
