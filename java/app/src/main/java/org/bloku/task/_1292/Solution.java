package org.bloku.task._1292;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Maximum Side Length of a Square with Sum Less than or Equal to Threshold")
@Topics({ARRAY, BINARY_SEARCH, MATRIX, PREFIX_SUM})
class Solution {

  public int maxSideLength(int[][] mat, int threshold) {
    int m = mat.length, n = mat[0].length;
    int low = 0, high = Math.min(m, n);
    int[][] prefix = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        prefix[i][j] =
            mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
      }
    }
    while (low <= high) {
      int mid = ((high - low) >> 1) + low;
      if (check(prefix, mid, threshold)) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low - 1;
  }

  private boolean check(int[][] prefix, int size, int threshold) {
    int m = prefix.length - 1, n = prefix[0].length - 1;
    for (int i = 0; i <= m - size; i++) {
      for (int j = 0; j <= n - size; j++) {
        int sum =
            prefix[i + size][j + size] - prefix[i + size][j] - prefix[i][j + size] + prefix[i][j];
        if (sum <= threshold) return true;
      }
    }
    return false;
  }
}
