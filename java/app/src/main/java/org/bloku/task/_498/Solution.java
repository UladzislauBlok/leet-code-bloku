package org.bloku.task._498;

import static org.bloku.util.Topic.*;

import org.bloku.util.LeetCodeName;
import org.bloku.util.Topics;

@LeetCodeName("Diagonal Traverse")
@Topics({ARRAY, MATRIX})
class Solution {

  // two operation depends on direction +1-1 or -1+1
  public int[] findDiagonalOrder(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    int[] res = new int[m * n];
    if (m == 1) {
      System.arraycopy(mat[0], 0, res, 0, n);
      return res;
    }
    if (n == 1) {
      for (int i = 0; i < m; i++) {
        res[i] = mat[i][0];
      }
      return res;
    }
    int idx = 0, a = 0, b = 0;
    int[] op = new int[] {+1, -1};
    while (a < m && b < n) {
      op[0] *= -1;
      op[1] *= -1;
      int endA;
      int endB;
      if (op[0] == 1) {
        endA = m - 1;
        endB = 0;
      } else {
        endA = 0;
        endB = n - 1;
      }
      while (a != endA && b != endB) {
        res[idx++] = mat[a][b];
        a += op[0];
        b += op[1];
      }
      res[idx++] = mat[a][b];
      if (a == endA && b == endB && endB == n - 1) {
        a++;
      } else if (a == endA && b == endB && endB == 0) {
        b++;
      } else if (a == endA) {
        b++;
      } else if (b == endB) {
        a++;
      }
    }
    return res;
  }
}
