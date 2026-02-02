package org.bloku.task._3446;

import static org.bloku.util.Topic.*;

import java.util.ArrayList;
import java.util.List;
import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Sort Matrix by Diagonals")
@Topics({ARRAY, MATRIX, SORTING})
class Solution {

  // n*n*logn
  // max n = 10, so it's fine
  public int[][] sortMatrix(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    List<Integer> sortList = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int j = 0, k = i;
      while (k < m) {
        sortList.add(grid[k++][j++]);
      }
      sortList.sort((a, b) -> b - a);
      j = 0;
      k = i;
      int idx = 0;
      while (k < m) {
        grid[k++][j++] = sortList.get(idx++);
      }
      sortList.clear();
    }
    for (int j = 1; j < n; j++) {
      int i = 0, k = j;
      while (k < n) {
        sortList.add(grid[i++][k++]);
      }
      sortList.sort((a, b) -> a - b);
      i = 0;
      k = j;
      int idx = 0;
      while (k < n) {
        grid[i++][k++] = sortList.get(idx++);
      }
      sortList.clear();
    }
    return grid;
  }
}
