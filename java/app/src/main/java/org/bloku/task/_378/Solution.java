package org.bloku.task._378;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Kth Smallest Element in a Sorted Matrix")
@Topics({MATRIX, BINARY_SEARCH})
class Solution {

  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int low = matrix[0][0], high = matrix[n - 1][n - 1];
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (lessOrEquals(mid, matrix) < k) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    int result = matrix[0][0];
    for (int[] row : matrix) {
      for (int num : row) {
        if (num <= low) result = Math.max(result, num);
      }
    }
    return result;
  }

  private int lessOrEquals(int target, int[][] matrix) {
    int n = matrix.length;
    int row = n - 1, col = 0, count = 0;
    while (row >= 0 && col < n) {
      if (matrix[row][col] <= target) {
        count += row + 1;
        col++;
      } else {
        row--;
      }
    }
    return count;
  }
}
